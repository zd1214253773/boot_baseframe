package com.sungrow.wind.invoker;

import com.netflix.hystrix.Hystrix;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.sungrow.wind.exception.BaseException;
import com.sungrow.wind.exception.RemoteBackErrorException;
import com.sungrow.wind.exception.RemoteInvokeFailedException;
import com.sungrow.wind.global.data.HttpStatusEnum;
import com.sungrow.wind.global.data.Result;
import com.sungrow.wind.util.ThrowableUtils;
import com.sungrow.wind.exception.RemoteBackErrorException;
import com.sungrow.wind.exception.RemoteInvokeFailedException;
import com.sungrow.wind.util.ThrowableUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ZHENGDONG
 * @date 2021/3/5 10:32
 */
@ControllerAdvice
@ResponseBody
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FeignHyStrixExceptionHandler {

    @ExceptionHandler(HystrixRuntimeException.class)
    public Result<Object> defaultException(HystrixRuntimeException e, HttpServletResponse resp) {
        log.error(null, e);
        Throwable targetExp = e.getCause();
        for (int i = 0; i < 5; i++) {
            if (targetExp == null) {
                break;
            }
            if (targetExp instanceof RemoteBackErrorException) {
                break;
            } else if (targetExp.getSuppressed() != null && targetExp.getSuppressed().length > 0
                    && targetExp.getSuppressed()[0] instanceof RemoteInvokeFailedException) {
                targetExp = targetExp.getSuppressed()[0];
                break;
            }
            targetExp = targetExp.getCause();
        }
        if(targetExp == null) {
            targetExp = e;
        }
        return Result.fail(HttpStatusEnum.INTERNAL_SERVER_ERROR, targetExp.getMessage(), ThrowableUtils.printToString(targetExp));
    }

    

}


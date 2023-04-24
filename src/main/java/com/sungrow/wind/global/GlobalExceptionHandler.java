package com.sungrow.wind.global;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.sungrow.wind.exception.BaseException;
import com.sungrow.wind.exception.RemoteBackErrorException;
import com.sungrow.wind.exception.RemoteInvokeFailedException;
import com.sungrow.wind.global.data.HttpStatusEnum;
import com.sungrow.wind.global.data.Result;
import com.sungrow.wind.util.ThrowableUtils;
import com.sungrow.wind.exception.BaseException;
import com.sungrow.wind.global.data.HttpStatusEnum;
import com.sungrow.wind.util.ThrowableUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ZHENGDONG
 * @date 2020/11/14 16:52
 */

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @Value("${print.throwable.flag:false}")
    private boolean printThrowableFlag;


    /**
     * 默认处理方式
     *
     * @param e
     * @param resp
     */
    @ExceptionHandler(Throwable.class)
    public Result<Object> defaultException(Throwable e, HttpServletResponse resp) {
        log.error(null, e);
        return Result.fail(HttpStatusEnum.INTERNAL_SERVER_ERROR, e.getMessage(), getDataIfError(e));

    }

    @ExceptionHandler(BaseException.class)
    public Result<Object> defaultException(BaseException e, HttpServletResponse resp) {
        log.error(null, e);
        return Result.fail(e.getError(), e.getError().getMessage(), getDataIfError(e));
    }

    private Object getDataIfError(Throwable e) {
        return printThrowableFlag ? ThrowableUtils.printToString(e) : null;

    }


}

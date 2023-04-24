package com.sungrow.wind.invoker;

import com.sungrow.wind.constant.LanguageConstant;
import com.sungrow.wind.exception.RemoteBackErrorException;
import com.sungrow.wind.exception.RemoteInvokeFailedException;
import com.sungrow.wind.util.LanguageUtils;
import com.sungrow.wind.constant.LanguageConstant;
import com.sungrow.wind.exception.RemoteBackErrorException;
import com.sungrow.wind.exception.RemoteInvokeFailedException;
import com.sungrow.wind.util.LanguageUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ZHENGDONG
 * @date 2021/3/4 16:27
 */
public class DefaultFallBackInvocationHandler implements InvocationHandler {

    private final Throwable cause;

    public DefaultFallBackInvocationHandler(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(cause instanceof RemoteBackErrorException) {
            throw cause;
        }
        //HystrixBadRequestException
        cause.addSuppressed(new RemoteInvokeFailedException(LanguageUtils.getMesg(LanguageConstant.MESG_ERR_FAILINVOKE)
                + ",失败信息=>" + cause.getMessage()));
        throw cause;
    }
}

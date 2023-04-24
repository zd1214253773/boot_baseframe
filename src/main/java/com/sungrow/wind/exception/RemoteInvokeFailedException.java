package com.sungrow.wind.exception;

import feign.FeignException;

/**
 * @author ZHENGDONG
 * @date 2021/3/4 15:56
 */
//extend FeignException in order to avoid to be wrapped.
public class RemoteInvokeFailedException extends FeignException {


    public RemoteInvokeFailedException(String message) {
        super(message);
    }

    public RemoteInvokeFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}

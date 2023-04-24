package com.sungrow.wind.exception;

import com.sungrow.wind.global.data.Result;
import feign.FeignException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ZHENGDONG
 * @date 2021/3/4 15:56
 */
//extend FeignException in order to avoid to be wrapped.
@Getter
@Setter
public class RemoteBackErrorException extends FeignException {

    //远程返回的结果，code非200
    private Result backResult;

    public RemoteBackErrorException(String message) {
        super(message);
    }

    public RemoteBackErrorException(String message, Throwable cause) {
        super(message, cause);
    }

}

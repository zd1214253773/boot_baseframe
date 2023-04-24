package com.sungrow.wind.exception;

import com.sungrow.wind.global.data.ErrorCode;
import com.sungrow.wind.util.StringUtils;
import com.sungrow.wind.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mahongxiong
 * @date 2020/11/19 17:32
 */
public class BaseException  extends RuntimeException{

    private final ErrorCode error;
    private final HashMap<String, Object> data = new HashMap<>();

    public BaseException(ErrorCode error) {
        this.error = error;
    }

    public BaseException(ErrorCode error,String message, Map<String, Object> data) {

        super(error.getMessage());
        this.error = error;
        if (!StringUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }

    protected BaseException(ErrorCode error, String message, Map<String, Object> data, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = error;
        if (!StringUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }

    public ErrorCode getError() {
        return error;
    }

    public Map<String, Object> getData() {
        return data;
    }

}

package com.sungrow.wind.exception;

public class BusinessException extends RuntimeException {
  private final int code;
  private final String msg;


  public BusinessException(int code, String msg, Exception cause) {
    super(cause);
    this.code = code;
    this.msg = msg;
  }

  public BusinessException(int code, String msg) {
    this(code, msg, null);
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}

package com.sungrow.wind.global.data;

public class Result<T> {


    public Result() {
    }

    public Result(boolean success, int code) {
        this.setSuccess(success);
        this.setCode(code);
    }

    public Result(boolean success, int code, T data) {
        this.setSuccess(success);
        this.setCode(code);
        this.setData(data);
    }

    public Result(boolean success, int code, String msg) {
        this.setSuccess(success);
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public Result(boolean success, int code, String msg, T data) {
        this.setSuccess(success);
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    /**
     * 请求是否成功
     * true:成功
     * false：失败
     */
    private boolean success;

    /**
     * 状态码
     * 成功：200
     * 失败：其他
     */
    private int code;

    /**
     * 失败状态码描述
     * 如果成功不返回
     * 失败返回状态码对应的msg消息
     */
    private String msg;

    /**
     * 请求数据的结果
     */
    private T data;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<T>(true, 200);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(true, 200, data);
    }


    public static <T> Result<T> fail(HttpStatusEnum httpStatusEnum) {
        return new Result<T>(false, httpStatusEnum.code(), httpStatusEnum.reasonPhraseCN());
    }

    public static <T> Result<T> fail(HttpStatusEnum httpStatusEnum, String msg) {
        return new Result<T>(false, httpStatusEnum.code(), msg);
    }

    public static <T> Result<T> fail(HttpStatusEnum httpStatusEnum, String msg, T data) {
        return new Result<T>(false, httpStatusEnum.code(), msg, data);
    }

    public static <T> Result<T> fail(ErrorCode errorCode, String msg, T data) {
        return new Result<T>(false, errorCode.getCode(), msg, data);
    }
}

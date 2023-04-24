package com.sungrow.wind.global.data;



public enum ErrorCode {


    REQUEST_VALIDATION_FAILED(9999, "调用失败，请联系管理员"),
    PERMISSION_CHECK_FAILED(9998, "无权限查看，请联系系统管理员配置权限"),
    PERMISSION_INSERT_FAILED(9997, "无权限查看，请联系系统管理员配置权限"),
    PERMISSION_REPEAT(9996, "填报人、审核人设置冲突，请调整其中任一项"),
    PERMISSION_ERROR(9995, "填报人、审核人设置冲突"),
    INSERT_ERROR(9994, "数据已存在，请勿重复保存"),
    VERSION_ERROR(9993, "此年份指标版本不存在，请在先做指标版本设置"),
    VALID_ERROR(9992, "请先选择年份"),
    lOGIN_ERROR(401, "登录失败"),
    LOGIN_CEHCK_ERROR(9991, "登录失败（未设置机构ID）,请联系管理员");

    private final int code;

    private String message;

    ErrorCode(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}

package com.sungrow.wind.enumeration;



public enum StatusType {

    CHECK_UNSUBMIT("未提交","CHECK_UNSUBMIT"),

    CHECK_SUBMIT("已提交","CHECK_SUBMIT"),

    CHECK_FIRST_AGREE("已初审","CHECK_FIRST_AGREE"),

    CHECK_FINALLY_AGREE("已终审","CHECK_FINALLY_AGREE"),

    CHECK_RETURN("已退回","CHECK_RETURN"),

    CHECK_CALLBACK("已撤回","CHECK_CALLBACK");

    StatusType(String name,String value){

        this.name = name;
        this.value = value;
    }
    public static StatusType getStatusType(String value){
        for (StatusType c : StatusType.values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        throw new RuntimeException("不存在该状态");
    }
    private String name;

    private String value;



}

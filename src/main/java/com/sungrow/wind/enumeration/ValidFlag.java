package com.sungrow.wind.enumeration;

/**
 * @author ZHENGDONG
 * @date 2020/11/14 19:46
 */
public enum ValidFlag {
    Y("1"),
    N("0");

    private String flag;

    ValidFlag(String flag){
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

}

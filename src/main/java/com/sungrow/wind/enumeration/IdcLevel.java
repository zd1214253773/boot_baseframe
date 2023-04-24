package com.sungrow.wind.enumeration;

/**
 * @author ZHENGDONG
 * @date 2020/11/20 21:22
 */
public enum IdcLevel {

    /**
     * 一级
     */
    LEVEL_FIRST("一级"),
    /**
     * 二级
     */
    LEVEL_SECOND("二级"),
    /**
     * 三级
     */
    LEVEL_THIRD("三级");

    IdcLevel(String name) {
        this.name = name;
    }


    private String name;
}

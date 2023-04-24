package com.sungrow.wind.enumeration;

/**
 * @author ZHENGDONG
 * @date 2020/11/20 21:18
 */
public enum IdcCalculateType {

    /**
     * 基础类型
     */
    LEVEL_BASE("基础类型"),

    /**
     * 复合类型
     */
    CACULATE_COMPLEX("复合类型");

    IdcCalculateType(String name) {
        this.name = name;
    }

    private String name;


}

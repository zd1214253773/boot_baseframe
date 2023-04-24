package com.sungrow.wind.enumeration;

/**
 * @author ZHENGDONG
 * @date 2020/11/20 23:34
 */
public enum ObtainType {

    /**
     * 填报
     */
    OBTAIN_TYPE_WRITE("填报"),
    /**
     * 抽取
     */
    OBTAIN_TYPE_COLLECT("抽取");

    private String name;


    ObtainType(String name) {
        this.name = name;
    }
}

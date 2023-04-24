package com.sungrow.wind.enumeration;

/**
 * @author ZHENGDONG
 * @date 2021/1/18 15:27
 */
public enum WrittenLevel {
    WRITE_LEVEL_HOSPITAL("院级"),
    WRITE_LEVEL_DEPART("科级");



    WrittenLevel(String name) {
        this.name = name;
    }

    private String name;
}

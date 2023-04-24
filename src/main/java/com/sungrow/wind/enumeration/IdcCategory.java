package com.sungrow.wind.enumeration;

/**
 * @author ZHENGDONG
 * @date 2020/11/20 21:25
 */
@Deprecated
public enum IdcCategory {
    //[国标,省标,市标,院标]
    /**
     * 国标	CATEGORY_COU	0		CATEGORY
     * 省标	CATEGORY_PRO	1		CATEGORY
     * 市标	CATEGORY_CITY	2		CATEGORY
     * 院标	CATEGORY_HOS	3		CATEGORY
     */
    CATEGORY_COU("国标"),
    CATEGORY_PRO("省标"),
    CATEGORY_CITY("市标"),
    CATEGORY_HOS("院标");

    IdcCategory(String name) {
        this.name = name;
    }

    private String name;

}


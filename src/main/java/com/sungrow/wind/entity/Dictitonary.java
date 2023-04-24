package com.sungrow.wind.entity;

import com.sungrow.wind.annotation.PrimaryKey;
import lombok.Data;

import java.util.Date;

@Data
public class Dictitonary {
    /**
     *   字典代理键
     */
    @PrimaryKey
    private String dictionaryId;

    /**
     *   条目父键（支持树结构）
     */
    private String parentItemKey;

    /**
     *   条目值
     */
    private String itemValue;

    /**
     *   条目码
     */
    private String itemCode;

    /**
     *   排序序号
     */
    private Integer sequence;

    /**
     *   条目说明
     */
    private String itemDescribe;

    /**
     *   条目组别
     */
    private String groupKey;

    /**
     *   创建时间
     */
    private Date createTime;

    /**
     *   注册人工号
     */
    private String operCode;

    /**
     *   更新时间
     */
    private String operName;

    /**
     */
    private Date updateTime;

    /**
     *   更新人工号
     */
    private String modifyerCode;

    /**
     *   更新人姓名
     */
    private String modifyerName;

    /**
     *   是否可用：1可用，0不可用
     */
    private String valid;
}
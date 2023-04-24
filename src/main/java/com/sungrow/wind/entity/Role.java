package com.sungrow.wind.entity;

import com.sungrow.wind.annotation.PrimaryKey;
import lombok.Data;

import java.util.Date;

@Data
public class Role {
    /**
     *   主键id
     */
    @PrimaryKey
    private String roleId;

    /**
     *   角色类型
     */
    private String role;

    /**
     *   指标版本
     */
    private Integer idcVersion;

    /**
     *   指标id
     */
    private String idcExtendId;

    /**
     *   指标名称
     */
    private String idcName;

    /**
     *   上报权（Y-有，N-无）
     */
    private String reportPermission;

    /**
     *   上报人
     */
    private String reportUser;

    /**
     *   审批权（Y-有，N-无）
     */
    private String approvePermission;

    /**
     *   审批人
     */
    private String approveUser;

    /**
     *   查看权（Y-有，N-无）
     */
    private String lookPermission;

    /**
     *   科室id
     */
    private String depId;

    /**
     *   科室名称
     */
    private String depName;

    /**
     *   创建时间
     */
    private Date createTime;

    /**
     *   操作人编号
     */
    private String operCode;

    /**
     *   操作人姓名
     */
    private String operName;

    /**
     *   更新时间
     */
    private Date updateTime;

    /**
     *   修改人编号
     */
    private String modifyerCode;

    /**
     *   修改人姓名
     */
    private String modifyerName;

    /**
     *   是否启用
     */
    private String valid;

    private String source;

    private String idcLevel;

    /**
     *   指标分类1[医疗质量]
     */
    private String idcClassifyOne;


    /**
     *   审批人姓名
     */
    private String approveUserName;

    /**
     *   上报人姓名
     */
    private String reportUserName;

    /**
     *   医院id
     */
    private String hospitalId;

    /**
     *   最终审批人审批权（Y-有，N-无）
     */
    private String finallyPermission;

    /**
     *   最终审批人
     */
    private String finallyUser;

    private String lookUser;

    private  String finallyUserName;

    /**
     *   终审科室
     */
    private String finallyDep;
}
package com.sungrow.wind.vo;

import com.sungrow.wind.annotation.PrimaryKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class RoleVO {
    /**
     *   主键id
     */
    @PrimaryKey
    @ApiModelProperty(value="主键id")
    private String roleId;

    /**
     *   角色类型
     */
    @ApiModelProperty(value="角色类型")
    private String role;

    /**
     *   指标版本
     */
    @ApiModelProperty(value="指标版本")
    private Integer idcVersion;

    /**
     *   指标id
     */
    @ApiModelProperty(value="指标id")
    private String idcExtendId;

    /**
     *   指标名称
     */
    @ApiModelProperty(value="指标名称")
    private String idcName;

    /**
     *   上报权（Y-有，N-无）
     */
    @ApiModelProperty(value="上报权（Y-有，N-无）")
    private String reportPermission;

    /**
     *   上报人
     */
    @ApiModelProperty(value="上报人")
    private String reportUser;

    /**
     *   上报人姓名
     */
    @ApiModelProperty(value="上报人姓名")
    private String reportUserName;

    /**
     *   审批权（Y-有，N-无）
     */
    @ApiModelProperty(value="审批权（Y-有，N-无）")
    private String approvePermission;

    /**
     *   审批人
     */
    @ApiModelProperty(value="审批人")
    private String approveUser;

    /**
     *   审批人姓名
     */
    @ApiModelProperty(value="审批人姓名")
    private String approveUserName;

    /**
     *   查看权（Y-有，N-无）
     */
    @ApiModelProperty(value="查看权（Y-有，N-无）")
    private String lookPermission;

    /**
     *   科室id
     */
    @ApiModelProperty(value="科室id")
    private String depId;

    /**
     *   科室名称
     */
    @ApiModelProperty(value="科室名称")
    private String depName;

    @ApiModelProperty(value="分类来源")
    private String source;

    @ApiModelProperty(value="指标级别")
    private String idcLevel;

    /**
     *   指标分类1[医疗质量]
     */
    @ApiModelProperty(value="指标分类1[医疗质量]")
    private String idcClassifyOne;

    /**
     *   医院id
     */
    @ApiModelProperty(value="医院id")
    private String hospitalId;

    /**
     *   多个指标id
     */
    @ApiModelProperty(value="多个指标id")
    private List<String> idcExtendIdList;

    /**
     *   最终审批人审批权（Y-有，N-无）
     */
    @ApiModelProperty(value="审批权（Y-有，N-无）")
    private String finallyPermission;

    /**
     *   最终审批人
     */
    @ApiModelProperty(value="最终审批人")
    private String finallyUser;

    /**
     *   查看人
     */
    @ApiModelProperty(value="查看人")
    private String lookUser;

    /**
     *   最终审批人姓名
     */
    @ApiModelProperty(value="最终审批人姓名")
    private  String finallyUserName;

    /**
     *   终审科室
     */
    @ApiModelProperty(value="终审科室")
    private String finallyDep;

}
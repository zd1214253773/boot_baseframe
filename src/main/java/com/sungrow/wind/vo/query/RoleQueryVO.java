package com.sungrow.wind.vo.query;

import com.sungrow.wind.annotation.PrimaryKey;
import com.sungrow.wind.vo.page.BasePageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class RoleQueryVO extends BasePageInfo {
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

    @ApiModelProperty(value="非当前指标:1-非当前，其他未当前")
    private String idcExtendFlag;

    /**
     *   医院id
     */
    @ApiModelProperty(value="医院id")
    private String hospitalId;

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
     *   终审科室
     */
    @ApiModelProperty(value="终审科室")
    private String finallyDep;

}
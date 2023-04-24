package com.sungrow.wind.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@ApiModel
@Data
public class User implements Serializable {
  private static final long serialVersionUID = -1046244035844249120L;

  @ApiModelProperty("用户id")
  private String userId;

  @ApiModelProperty("用户名")
  private String userName;

  @ApiModelProperty("密码")
  private String userPassword;

  @ApiModelProperty("密码")
  private String password;

  @ApiModelProperty("用户类型 0：系统用户 1：员工 2：患者")
  private Short userType;

  @ApiModelProperty("展示名")
  private String displayName;

  @ApiModelProperty("工号 ")
  private String empNo;

  @ApiModelProperty("患者id ")
  private String pId;

  @ApiModelProperty("0：禁用 1：启用")
  private Short status;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("更新时间")
  private Date updateTime;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @ApiModelProperty("创建时间")
  private Date createTime;

  @ApiModelProperty("机构编码")
  private String orgCode;

  @ApiModelProperty("唯一标识")
  private String userIdentifyCode;

  @ApiModelProperty("性别 0:女 1：男")
  private String userSex;

  @ApiModelProperty("描述")
  private String userDescription;

  @ApiModelProperty("主索引id")
  private String employeeId;

  @ApiModelProperty("科室编码")
  private String deptCode;

  @ApiModelProperty("科室名称")
  private String deptName;

  @ApiModelProperty(value = "创建人")
  private String createBy;

  @ApiModelProperty(value = "更新人")
  private String updateBy;
}

package com.sungrow.wind.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(description = "系统功能实体")
public class SysFunction implements Serializable {
  /**
   * 功能/页面表ID
   */
  @ApiModelProperty(value = "功能/页面表ID", example = "123")
  private String funcId;
  /**
   * 功能/页面名称
   */
  @ApiModelProperty(value = "功能/页面名称")
  private String funcName;
  /**
   * 功能/页面编码
   */
  @ApiModelProperty(value = "功能/页面编码")
  private String funcCode;
  /**
   *
   */
  @ApiModelProperty(value = "路径")
  private String url;
  /**
   * 功能图标
   */
  @ApiModelProperty(value = "功能图标")
  private String funcIcon;
  /**
   * 父级ID
   */
  @ApiModelProperty(value = "父级ID", example = "123")
  private String parentId;
  /**
   * 显示顺序
   */
  @ApiModelProperty(value = "显示顺序", example = "123")
  private Integer seqNo;
  /**
   * 所属系统编码
   */
  @ApiModelProperty(value = "所属系统编码")
  private String systemCode;
  /**
   * 功能类型(0:系统 1:页面 2:控件)
   */
  @ApiModelProperty(value = "功能类型(0:系统 1:页面 2:控件)")
  private Short funcType;
  /**
   * 状态(0:禁用 1:启用)
   */
  @ApiModelProperty(value = " 状态(0:禁用 1:启用)")
  private Short status;
  /**
   *
   */
  @ApiModelProperty(value = "", example = "123")
  private Integer isCaSystem;
  /**
   *
   */
  @ApiModelProperty(value = "")
  private String component;
  /**
   * 创建时间
   */
  @ApiModelProperty(value = "创建时间")
  private Date createTime;
  /**
   * 修改时间
   */
  @ApiModelProperty(value = "修改时间")
  private String createBy;
  /**
   * 修改时间
   */
  @ApiModelProperty(value = "修改时间")
  private Date updateTime;
  /**
   * 修改人
   */
  @ApiModelProperty(value = "修改人")
  private String updateBy;
  @ApiModelProperty(value = "系统名称")
  private String sysName;
}

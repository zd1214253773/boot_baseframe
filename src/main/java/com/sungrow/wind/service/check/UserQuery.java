package com.sungrow.wind.service.check;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class UserQuery {
  @ApiModelProperty("机构编码")
  private String orgCode;
  @ApiModelProperty("科室编码")
  private String deptCode;

}

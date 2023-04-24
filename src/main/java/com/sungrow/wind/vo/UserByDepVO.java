package com.sungrow.wind.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserByDepVO {

    /**
     *   指标id
     */
    @ApiModelProperty(value="指标id")
    private String idcExtendId;

    /**
     *   科室id
     */
    @ApiModelProperty(value="科室id")
    private String depId;


    /**
     *   token
     */
    @ApiModelProperty(value="token")
    private String token;

}

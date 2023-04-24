package com.sungrow.wind.vo.view;

import com.sungrow.wind.annotation.PrimaryKey;
import com.sungrow.wind.entity.SysFunction;
import com.sungrow.wind.entity.User;
import com.sungrow.wind.entity.SysFunction;
import com.sungrow.wind.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class UserFunctionVO {

    /**
     *   功能列表
     */
    @PrimaryKey
    @ApiModelProperty(value="功能列表")
    private List<SysFunction> functionList;

    /**
     *   用户信息
     */
    @PrimaryKey
    @ApiModelProperty(value="用户信息")
    private User user;


}

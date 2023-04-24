package com.sungrow.wind.vo.query;

import com.sungrow.wind.annotation.PrimaryKey;
import com.sungrow.wind.vo.page.BasePageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class DictitonaryQueryVO extends BasePageInfo {
    /**
     *   字典代理键
     */
    @PrimaryKey
    @ApiModelProperty(value="字典代理键")
    private String dictionaryId;

    /**
     *   条目父键（支持树结构）
     */
    @ApiModelProperty(value="条目父键（支持树结构）")
    private String parentItemKey;

    /**
     *   条目值
     */
    @ApiModelProperty(value="条目值")
    private String itemValue;

    /**
     *   条目码
     */
    @ApiModelProperty(value="条目码")
    private String itemCode;

    /**
     *   排序序号
     */
    @ApiModelProperty(value="排序序号")
    private Integer sequence;

    /**
     *   条目说明
     */
    @ApiModelProperty(value="条目说明")
    private String itemDescribe;

    /**
     *   条目组别
     */
    @ApiModelProperty(value="条目组别")
    private String groupKey;
}
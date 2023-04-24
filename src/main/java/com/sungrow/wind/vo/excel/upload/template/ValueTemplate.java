package com.sungrow.wind.vo.excel.upload.template;

import com.sungrow.wind.global.excel.RowNumber;
import com.sungrow.wind.global.excel.annotatin.HeaderMap;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ZHENGDONG
 * @date 2020/12/31 14:27
 */
@Data
public class ValueTemplate extends RowNumber {
    /**
     *   指标最终的序号，如1.1
     */
    @HeaderMap
    @ApiModelProperty(value="指标最终的序号，如1.1")
    private String idcOrderFinal;

    /**
     * 上报结果
     */
    @HeaderMap
    @ApiModelProperty(value = "上报结果")
    private String idcValue;


}

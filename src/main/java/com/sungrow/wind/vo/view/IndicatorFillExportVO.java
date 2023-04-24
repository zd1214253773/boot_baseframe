package com.sungrow.wind.vo.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class IndicatorFillExportVO {

    private String idcName;

    private String dataUnit;

    private String count;

    private String idcValueFirst;

    private String remark;

    private String idcExtendId;

    private boolean look;

    //private String idcLevel;

    //private String wirttenDepart;

    //private String idcOrderFinal;

    private boolean wirttenFlag;

}

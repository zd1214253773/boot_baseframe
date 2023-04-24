package com.sungrow.wind.vo.excel.upload.template;

import com.sungrow.wind.global.excel.RowNumber;
import lombok.Data;

@Data
public class RegisterUploadVO extends RowNumber {


    private String targetVersion;

    private String targetOrder;

    private String targetName;

    private String targetResult;

    private String targetScore;

    private String targetStandard;


}

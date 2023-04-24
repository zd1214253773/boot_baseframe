package com.sungrow.wind.vo.excel.upload.template;

import com.sungrow.wind.annotation.PrimaryKey;
import com.sungrow.wind.global.excel.RowNumber;
import com.sungrow.wind.global.excel.annotatin.HeaderMap;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ZHENGDONG
 * @date 2020/11/29 3:22
 */
@Data
public class IndicatorExtendUploadTemplate extends RowNumber {

    /*@HeaderMap
    private String idcName;

    @HeaderMap
    private Integer idcYear;*/

    /**
     *   指标主键
     */
    @PrimaryKey
    @ApiModelProperty(value="指标主键")
    private String idcId;

    /**
     *   指标名称
     */
    @HeaderMap
    @ApiModelProperty(value="指标名称")
    private String idcName;

    /**
     *   指标序号
     */
    @HeaderMap
    @ApiModelProperty(value="指标序号")
    private Integer idcOrder;

    /**
     *   指标最终的序号，如1.1
     */
    @HeaderMap
    @ApiModelProperty(value="指标最终的序号，如1.1")
    private String idcOrderFinal;

    /**
     *   指标向导[检测比较,逐步提高,逐步降低]
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value="指标向导[检测比较,逐步提高,逐步降低]")
    private String idcGuide;

    /**
     *   指标参考值
     */
    @HeaderMap
    @ApiModelProperty(value="指标参考值")
    private String idcReferenceValue;

    /**
     *   结果分析类别[定性,定量]
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value="结果分析类别[定性,定量]")
    private String idcResolveType;

    /**
     *   指标属性的采集范围[门诊,急诊,住院]
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value="指标属性的采集范围[门诊,急诊,住院]")
    private String collectScope;

    /**
     *   数据合法性检测规则
     */
    @ApiModelProperty(value="数据合法性检测规则")
    private String dataCheckRuleId;

    /**
     *   指标值的单位
     */
    @HeaderMap
    @ApiModelProperty(value="指标值的单位")
    private String dataUnit;

    /**
     *   内部属性
     */
    @HeaderMap
    @ApiModelProperty(value="内部属性")
    private String innerAttr;

    /**
     *   上级属性id
     */
    @ApiModelProperty(value="上级属性id")
    private String idcParentId;

    /**
     *   定义及说明
     */
    @HeaderMap
    @ApiModelProperty(value="定义及说明")
    private String remark;

    /**
     *   复合或者展现指标的计算策略，形如#{1.1}/#{1.2}，使用最终的序号，如果是支持租户，那么使用idc_id
     */
    @HeaderMap
    @ApiModelProperty(value="复合或者展现指标的计算策略，形如#{1.1}/#{1.2}，使用最终的序号，如果是支持租户，那么使用idc_id")
    private String dataCalculationFormula;

    /**
     *   指标级别[国标,省标,市标,院标]
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value="指标级别[国标,省标,市标,院标]")
    private String idcCategory;

    /**
     *   指标级别[一级,二级,三级]
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value="指标级别[一级,二级,三级]")
    private String idcLevel;

    /**
     *   医院id
     */
    @HeaderMap
    @ApiModelProperty(value="医院id")
    private String hospitalId;

    /**
     *   指标类型[基础类型,复合类型]
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value="指标类型[基础类型,复合类型]")
    private String idcCalculateType;

    /**
     *   指标的有效年份（可做版本区分）
     */
    @HeaderMap
    @ApiModelProperty(value="指标的有效年份（可做版本区分）")
    private Integer idcYear;

    /**
     *   时间维度
     */
    @HeaderMap
    @ApiModelProperty(value="时间维度")
    private String timeDimesionLevel;

    /**
     *   单元维度
     */
    @HeaderMap
    @ApiModelProperty(value="单元维度")
    private String unitDimensionLevel;


    /**
     *   指标最大值
     */
    @HeaderMap
    @ApiModelProperty(value="指标最大值")
    private Double dataMax;

    /**
     *   指标最小值
     */
    @HeaderMap
    @ApiModelProperty(value="指标最小值")
    private Double dataMin;

    /**
     *   指标分类1[医疗质量]
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value="指标分类1[医疗质量]")
    private String idcClassifyOne;

    /**
     *   指标分类2[医疗质量-子分类]
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value="指标分类2[医疗质量-子分类]")
    private String idcClassifyTwo;

    /**
     *   指标分类1[医疗质量]
     */
    @HeaderMap
    @ApiModelProperty(value="指标分类1[医疗质量]-内容")
    private String idcClassifyOneValue;

    /**
     *   指标分类2[医疗质量-子分类]
     */
    @HeaderMap
    @ApiModelProperty(value="指标分类2[医疗质量-子分类]-内容")
    private String idcClassifyTwoValue;

    /**
     *   指标级别[国标,省标,市标,院标]
     */

    @ApiModelProperty(value="指标级别[国标,省标,市标,院标]-内容")
    private String idcCategoryValue;

    /**
     *   指标级别[一级,二级,三级]
     */
    @ApiModelProperty(value="指标级别[一级,二级,三级]-内容")
    private String idcLevelValue;


    /**
     * 指标扩展id
     */
    @ApiModelProperty(value = "指标扩展id")
    private String idcExtendId;



    /**
     * 数据采集方式[抽取,填报]
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value = "数据采集方式[抽取,填报]")
    private String obtainType;

    /**
     * 数据来源的表名
     */
    @HeaderMap
    @ApiModelProperty(value = "数据来源的表名")
    private String sourceTable;

    /**
     * 数据来源表的列名
     */
    @HeaderMap
    @ApiModelProperty(value = "数据来源表的列名")
    private String sourceTableColumn;

    /**
     * 填报科室(也是数据来源科室，数据填报审核使用)
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value = "填报科室(也是数据来源科室，数据填报审核使用)")
    private String wirttenDepart;

    /**
     * 填报频率[年,季,月]
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value = "填报频率[年,季,月]")
    private String wirttenRate;

    /**
     * 审核科室
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value = "审核科室")
    private String auditDepart;

    /**
     * 采集频率[年,季,月]
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value = "采集频率[年,季,月]")
    private String collectRate;

    /**
     * 采集科室
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value = "采集科室")
    private String collectDepart;

    /**
     * 采集系统[HIS,LIS,PACS,其它]
     */
    @HeaderMap(translate=true)
    @ApiModelProperty(value = "采集系统[HIS,LIS,PACS,其它]")
    private String collectSystem;

    /**
     * 采集目标表
     */
    @HeaderMap
    @ApiModelProperty(value = "采集目标表")
    private String collectTable;

    /**
     * 采集目标列
     */
    @HeaderMap
    @ApiModelProperty(value = "采集目标列")
    private String collectField;

    /**
     * 上报结果
     */
    @HeaderMap
    @ApiModelProperty(value = "上报结果")
    private String idcValue;

    //@HeaderMap
    //@ApiModelProperty(value = "上级对象")
    //private IndicatorManageVO parent;

    @HeaderMap
    @ApiModelProperty(value = "有效位数")
    private Integer dataValidLength;


}

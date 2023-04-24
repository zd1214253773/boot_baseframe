package com.sungrow.wind.vo.page;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sungrow.wind.constant.Constant;
import com.sungrow.wind.enumeration.OrderType;
import com.sungrow.wind.enumeration.OrderType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * @author ZHENGDONG
 * @date 2020/11/14 15:40
 */
@Data
@Slf4j
public class PageParam {
    /**
     * 第几页 从1开始
     */
    private int pageNum;

    /**
     * 页容量
     */
    private int pageSize;

    /**
     * 总条数
     */
    //@JsonIgnore
    @ApiModelProperty(hidden=true)
    private int total;

    /**
     * 总页数
     */
    //@JsonIgnore
    @ApiModelProperty(hidden=true)
    private int pages;

    /**
     * 排序列名
     */
    private String orderBy;

    /**
     * 排序类型，升序还是降序
     */
    private OrderType orderType;

    /**
     * like " create_time desc"
     * 该属性排序优先级最高。
     */
    private String nativeOrderBy;

    public PageParam() {
        this.pageNum = 1;
        this.pageSize = 10;
        this.orderBy = Constant.LAST_UPDATE_DATE_COL_NAME;
        this.orderType = OrderType.DESC;
    }

    /**
     * 检验参数合法性
     */
    public void check() {
        if (this.pageNum < 0
                || this.pageSize < 1) {
            throw new IllegalArgumentException(String.format("parameters no correct. pageNum:s%,pageSize:s%", pageNum, pageSize));
        }
        if (StringUtils.isEmpty(this.nativeOrderBy) && (StringUtils.isEmpty(this.orderBy)
                || this.orderType == null)) {
            throw new IllegalArgumentException(String.format("parameters no correct. " +
                    "orderBy:s%,orderType:s%", orderBy, orderType));
        }
    }

    public String finalOderBy() {
        if (StringUtils.isEmpty(this.nativeOrderBy)) {
            return this.orderBy + Constant.SPACE + this.orderType;
        }
        return this.nativeOrderBy;
    }
}

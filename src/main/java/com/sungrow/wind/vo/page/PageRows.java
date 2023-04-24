package com.sungrow.wind.vo.page;

import com.github.pagehelper.PageInfo;
import com.sungrow.wind.util.BeanUtils;
import com.sungrow.wind.util.BeanUtils;
import lombok.Data;

import java.util.List;

/**
 * @author ZHENGDONG
 * @date 2020/11/14 19:15
 */
@Data
public class PageRows<T> {
    /**
     * 第几页 从0开始
     */
    private int pageNum;

    /**
     * 页容量
     */
    private int pageSize;

    /**
     * 总条数
     */
    private long total;

    /**
     * 总页数
     */
    private int pages;

    private List<T> rows;

    public PageRows(PageInfo pageInfo) {
        this.pageNum = pageInfo.getPageNum();
        this.pages = pageInfo.getPages();
        this.pageSize = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
        this.setRows(pageInfo.getList());
    }
    //with Convert and set rows
    public PageRows(PageInfo pageInfo, Class<T> toClass) {
        this.pageNum = pageInfo.getPageNum();
        this.pages = pageInfo.getPages();
        this.pageSize = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
        this.setRows(BeanUtils.copy(pageInfo.getList(), toClass));
    }

}

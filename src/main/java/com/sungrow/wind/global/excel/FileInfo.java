package com.sungrow.wind.global.excel;

/**
 * @author ZHENGDONG
 * @date 2020/11/29 0:25
 */
@FunctionalInterface
public interface FileInfo {
    /**
     * 表头行数
     * @return
     */

    default int getContentStartIndex() {
        return this.getHeadRowIndex() + 1;
    }

    default int getHeadRowIndex() {
        return 0;
    }

    String getFileName();

}

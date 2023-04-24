package com.sungrow.wind.global.excel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author ZHENGDONG
 * @date 2020/11/29 0:11
 */

public interface FileReader {
    /**
     *
     * @param inputStream
     * @return
     */
    List<Map<String, String>> read(InputStream inputStream, FileInfo fileInfo);

}

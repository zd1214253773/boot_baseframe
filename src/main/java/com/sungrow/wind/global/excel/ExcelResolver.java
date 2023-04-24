package com.sungrow.wind.global.excel;

import java.io.InputStream;

/**
 * @author ZHENGDONG
 * @date 2020/11/29 12:30
 */
public class ExcelResolver extends AbstractResolver {


    private final Class elementClass;

    public ExcelResolver(InputStream inputStream, FileInfo fileInfo, FileReader fileReader, Class elementClass) {
        super(inputStream, fileInfo, fileReader);
        this.elementClass = elementClass;
    }


    public ExcelResolver(InputStream inputStream, String fileName, Class elementClass) {

        this(inputStream, () -> fileName, new ExcelFileReader(), elementClass);
    }

    public ExcelResolver(InputStream inputStream, FileInfo fileInfo, Class elementClass) {

        this(inputStream, fileInfo, new ExcelFileReader(), elementClass);
    }

    @Override
    public Class getElementClass() {
        return elementClass;
    }
}

package com.sungrow.wind.global.excel;

import com.sungrow.wind.global.excel.annotatin.HeaderMap;
import com.sungrow.wind.service.cache.CommonCacheServiceUtil;
import com.sungrow.wind.util.ReflectUtils;
import com.sungrow.wind.util.StringUtils;
import com.sungrow.wind.global.excel.annotatin.HeaderMap;
import com.sungrow.wind.service.cache.CommonCacheServiceUtil;
import com.sungrow.wind.util.ReflectUtils;
import com.sungrow.wind.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapperImpl;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author ZHENGDONG
 * @date 2020/11/29 1:18
 */
@Slf4j
public abstract class AbstractResolver<T extends RowNumber> implements Resover<T> {

    private final FileInfo fileInfo;

    private final FileReader fileReader;

    private final InputStream inputStream;

    public AbstractResolver(InputStream inputStream, FileInfo fileInfo, FileReader fileReader) {
        this.inputStream = inputStream;
        this.fileInfo = fileInfo;
        this.fileReader = fileReader;
    }


    /**
     * 只能调用一次
     * @return
     */
    @Override
    public List<T> resolve() {
        List<Map<String, String>> listMap = fileReader.read(inputStream, fileInfo);
        List<T> instances = new ArrayList<>(listMap.size());
        for (int i = 0; i < listMap.size(); i++) {
            instances.add(toInstance(listMap.get(i), i));
        }

        return instances;
    }

    /**
     * 如果字段没有明确制定headName，则属性名驼峰转大写下划线，进行head匹配
     * @param f
     * @param headName
     * @return
     */
    protected String getMapFileHeaderName(Field f, String headName) {
        if(StringUtils.isEmpty(headName)) {
           return StringUtils.upperCase(StringUtils.humpToLine(f.getName()));
        }
        return headName;
    }


    private T toInstance(Map<String, String> rowMap, int index) {
        T t = null;
        try {
            t = this.getElementClass().newInstance();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        t.setRowNum(index + fileInfo.getContentStartIndex());
        //AllFieldMap
        List<Field> fields = ReflectUtils.getAllAnnotatedField(this.getElementClass(), HeaderMap.class);
        BeanWrapperImpl wrapper = new BeanWrapperImpl(t);
        for (Field f : fields) {

            HeaderMap headerMap = f.getAnnotation(HeaderMap.class);

            String valInExcel = StringUtils.trim(rowMap.get(getMapFileHeaderName(f, headerMap.headName())));
            this.valid(valInExcel, headerMap, t.getRowNum(), headerMap.headName());
            ////字典转译

            if (valInExcel != null) {
                try {
                    //Object val = convert(f.getType(), valInExcel);
                    Object val = wrapper.convertForProperty(valInExcel, f.getName());
                    if(headerMap.translate()) {
                        val = this.translate(val);
                    }

                    wrapper.setPropertyValue(f.getName(), val);
                } catch (Exception e) {
                    throw new RuntimeException(MessageFormat.format("行号：[{0}],列名[{1}],值[{2}]未能转成类型[{3}]。"
                            , t.getRowNum(), headerMap.headName(), valInExcel, f.getType()), e);
                }

            }
        }



        return t;
    }

    /**
     * 翻译
     * @param val
     * @return
     */
    private Object translate(Object val) {
        if(val instanceof String) {
            Map<String, String> valueCodeMap = this.getTranslateMap();
            String rValue = valueCodeMap.get(val);
            if(rValue != null) {
                return rValue;
            } else {
                log.warn(MessageFormat.format("值[{0}],没能翻译成code.", val));
            }
        }
        return val;
    }

    /**
     * 获取翻译的字典
     * @return
     */

    protected Map<String, String> getTranslateMap() {
       return CommonCacheServiceUtil.getValueCodeMap();
    }

    /**
     * 根据注解进行校验
     * @param valInExcel
     * @param headerMap
     * @param rowNum
     * @param colName
     */
    private void valid(String valInExcel, HeaderMap headerMap, int rowNum, String colName) {
        if (StringUtils.isEmpty(valInExcel)) {
            if (headerMap.required()) {
                throw new RuntimeException(MessageFormat.format("行号：[{0}],列名[{1}],必填项没有填充值。", rowNum, colName));
            }

        } else if (headerMap.length() > 0 && valInExcel.length() > headerMap.length()) {
            throw new RuntimeException(MessageFormat.format("行号：[{0}],列名[{1}],内容长度超过最大值[{2}]。", rowNum, colName, headerMap.length()));
        }
    }


}

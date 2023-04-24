package com.sungrow.wind.util;

import com.sungrow.wind.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class BeanUtils {
    /**
     * 转换并拷贝属性
     *
     * @param source
     * @param toClass
     * @param <T>
     * @return
     */
    public static <T> T copy(Object source, Class<T> toClass) {
        if (source == null) {
            return null;
        }
        T t = null;
        try {
            t = toClass.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        org.springframework.beans.BeanUtils.copyProperties(source, t);
        return t;
    }

    /**
     * 转换并拷贝元素属性
     *
     * @param source
     * @param toClass
     * @param <T>
     * @return
     */
    public static <T> List<T> copy(Collection source, Class<T> toClass) {
        if (source == null) {
            return Collections.emptyList();
        }
        List<T> list = new ArrayList<>(source.size());
        for (Object o : source) {
            T t = null;
            if ((t = copy(o, toClass)) != null) {
                list.add(t);
            }
        }
        return list;
    }

    /**
     * 填充属性的值（当该属性值为空时填充）
     * @param target
     * @param propName
     * @param value
     */
    public static void fillIfNull(Object target, String propName, Object value) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(target);
        //或者空白也需要填入
        Object oldValue = null;
        if ((oldValue = beanWrapper.getPropertyValue(propName)) == null || (oldValue instanceof String && oldValue.equals(Constant.BLANK))) {
            beanWrapper.setPropertyValue(propName, value);
        }
    }

    /**
     * 填充属性的值
     *
     * @param target
     * @param propName
     * @param value
     */
    public static void fill(Object target, String propName, Object value) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(target);
        beanWrapper.setPropertyValue(propName, value);
    }


    /**
     * 深度复制
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T extends Serializable> T deepClone(T object) {
        try {
            //将对象写入流中
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(object);
            //从流中取出
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

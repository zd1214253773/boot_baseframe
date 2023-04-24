package com.sungrow.wind.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * @author ZHENGDONG
 * @date 2020/11/29 2:04
 */
@Slf4j
public class ReflectUtils {
    private static final Map<Class, List<Field>> ALL_FIELD_CACHE_MAP = new ConcurrentHashMap<>();

    private static final Map<Class, List<Field>> ANNOTATED_CACHE_MAP = new ConcurrentHashMap<>();

    /**
     * 获取所有字段
     *
     * @param t
     * @return
     */
    public static List<Field> getAllFields(Class t) {
        return ALL_FIELD_CACHE_MAP.computeIfAbsent(t, k -> getFields(k));
    }

    private static List<Field> getFields(Class t) {
        log.info("t=>>>>>>>>>>>>>>>>" + t);
        if (t == Object.class || t == null) {
            return Collections.emptyList();
        }
        List<Field> fields = Arrays.asList(t.getDeclaredFields()).stream().collect(toList());
        fields.addAll(getFields(t.getSuperclass()));
        log.info("fields" + fields.size());
        return fields;
    }

    /**
     * 获取某个类中所有标记注解annotationClass的字段
     * @param tClass
     * @param annotationClass
     * @return
     */
    public static List<Field> getAllAnnotatedField(Class tClass, Class<? extends Annotation> annotationClass) {
        List<Field> fields = getAllFields(tClass);
        return ANNOTATED_CACHE_MAP.computeIfAbsent(tClass,
                k -> getAllFields(k).stream().filter(f -> f.isAnnotationPresent(annotationClass)).collect(toList()));
    }
}

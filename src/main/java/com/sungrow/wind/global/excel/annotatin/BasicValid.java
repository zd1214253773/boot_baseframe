package com.sungrow.wind.global.excel.annotatin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ZHENGDONG
 * @date 2020/11/28 23:57
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface BasicValid {
    /**
     * 是否必填
     * @return
     */
    boolean required() default false;

    /**
     * 最大长度
     * 0表示不用填写
     * @return
     */
    int length() default 0;

}

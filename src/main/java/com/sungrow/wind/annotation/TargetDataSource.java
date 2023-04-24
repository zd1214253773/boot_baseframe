package com.sungrow.wind.annotation;

import java.lang.annotation.*;

/**
 * @author ZHENGDONG
 * @date 2021/1/6 15:10
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

    String value();

}

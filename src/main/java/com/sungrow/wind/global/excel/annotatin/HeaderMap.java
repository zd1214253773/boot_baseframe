package com.sungrow.wind.global.excel.annotatin;

import com.sungrow.wind.constant.Constant;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.sungrow.wind.constant.Constant.EMPTY;

/**
 * @author ZHENGDONG
 * @date 2020/11/28 23:47
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@BasicValid
public @interface HeaderMap {
    /**
     * 映射excel的表头名称
     * @return
     */

    String headName() default Constant.EMPTY;

    /**
     * 是否进行字典翻译
     * @return
     */
    boolean translate() default false;

    /**
     *
     */

    /**
     * 是否必填
     * @return
     */
    @AliasFor(annotation = BasicValid.class)
     boolean required() default false;

    /**
     * 最大长度
     * 0表示不用填写
     * @return
     */
    @AliasFor(annotation = BasicValid.class)
    int length() default 0;

}

package com.sungrow.wind.global;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PathMapping {

  @AliasFor("includes")
  String[] value() default {};

  @AliasFor("value")
  String[] includes() default {};

  String[] excludes() default {};
}

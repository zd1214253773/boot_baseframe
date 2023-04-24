package com.sungrow.wind.aop;

import com.sungrow.wind.annotation.TargetDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ZHENGDONG
 * @date 2021/1/6 15:12
 */
@Aspect
@Order(-10) //保证该aop在@Transaction之前执行
@Component
@Slf4j
public class DynamicDataSourceAspect {

    /**
     * * @Before("@annotation(ds)")
     * 的意思是：@Before：在方法执行之前进行执行; @annotation(targetDataSource)：会拦截注解targetDataSource的方法，否则不拦截;
     * @param point
     * @param targetDataSource
     */
    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint point, TargetDataSource targetDataSource){
        //获取当前的指定数据源
        String dsID = targetDataSource.value();
        DynamicDataSourceContextHolder.setDataSourceType(dsID);

    }


    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource){
        //方法执行完毕后，销毁当前数据源信息，进行垃圾回收
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}

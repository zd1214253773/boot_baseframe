package com.sungrow.wind.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author ZHENGDONG
 * @date 2020/11/25 13:42
 */
@Component
public class SpringBeanUtils implements BeanFactoryAware {

    private static BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public static <T> T getBean(Class<T> tClass) {
       return beanFactory.getBean(tClass);
    }

}

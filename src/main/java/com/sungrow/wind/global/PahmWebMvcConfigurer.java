package com.sungrow.wind.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ZHENGDONG
 * @date 2020/11/14 19:41
 */

@Configuration
public class PahmWebMvcConfigurer implements WebMvcConfigurer {

    /*@Bean
    public HeaderInterceptor headerInterceptor(){
        return new HeaderInterceptor();
    }*/

    //@Autowired
    //private HeaderInterceptor headerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //registry.addInterceptor(headerInterceptor);
        // 可添加多个
//        registry.addInterceptor(new HeaderInterceptor());
        //registry.addInterceptor(new LoginInterceptor());
                //.addPathPatterns("/**");
    }
}

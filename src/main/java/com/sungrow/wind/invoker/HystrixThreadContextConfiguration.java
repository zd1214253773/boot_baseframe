package com.sungrow.wind.invoker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZHENGDONG
 * @date 2021/3/4 19:29
 */
@Configuration
public class HystrixThreadContextConfiguration {

    @Bean
    public DefaultHystrixConcurrencyStrategy defaultHystrixConcurrencyStrategy() {
        return new DefaultHystrixConcurrencyStrategy();
    }
}

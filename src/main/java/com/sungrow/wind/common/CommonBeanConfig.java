package com.sungrow.wind.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHENGDONG
 * @date 2020/11/30 11:09
 */
@Configuration
@Slf4j
public class CommonBeanConfig {

    public static int COUNT = Runtime.getRuntime().availableProcessors() * 20;

    @Bean
    public ExecutorService executorService() {
        log.info("线程数--------------{}",COUNT);
        return new ThreadPoolExecutor(COUNT, COUNT * 10,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(200));
    }


}

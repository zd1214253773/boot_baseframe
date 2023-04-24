package com.sungrow.wind.global.runner;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.sungrow.wind.enumeration.TimeDimeLevel;
import com.sungrow.wind.global.RequestHeader;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;

/**
 * 主要是为了数据预热，配合mybatis二级缓存使用
 *
 * @author ZHENGDONG
 * @date 2021/3/16 9:43
 */
@Component
@Slf4j
public class HotDataApplicationRunner implements ApplicationRunner, ApplicationContextAware {

    @Autowired
    private ExecutorService service;

    private ApplicationContext context;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("开始数据预热");
        service.execute(() -> {
            LoggerContext loggerContext = (ch.qos.logback.classic.LoggerContext) LoggerFactory.getILoggerFactory();

            String packageName = "com.sungrow.wind.dao.postgre";
            Logger logger = loggerContext.getLogger(packageName);
            Level level = logger.getLevel();
            logger.setLevel(Level.ERROR);
            Calendar dateNow = Calendar.getInstance();

            log.info("数据预热结束");
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}

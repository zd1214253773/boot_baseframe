package com.sungrow.wind;

import com.sungrow.wind.common.FeignCustomizedConfiguration;
import com.sungrow.wind.constant.CustomerSysPropConstant;
import com.sungrow.wind.util.SystemUtils;
import com.sungrow.wind.constant.CustomerSysPropConstant;
import com.sungrow.wind.util.SystemUtils;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@SpringBootApplication
@EnableSwagger2
@EnableScheduling
@EnableAspectJAutoProxy(exposeProxy=true)
@EnableFeignClients(basePackages= {"com.sungrow.wind.*"}, defaultConfiguration = FeignCustomizedConfiguration.class)
@MapperScan("com.sungrow.wind.dao.*")
public class Application {

    public static void main(String[] args) {

        log.info("启动完成!!!");
        SpringApplication.run(Application.class, args);
        log.info("启动完成!!!");
    }

    /**
     * 添加自定义系统变量
     */
    public static void initOherProp() {
        //spring.backgroundpreinitializer.ignore
        System.getProperties().setProperty("spring.backgroundpreinitializer.ignore", "true");
        System.getProperties().setProperty(CustomerSysPropConstant.PA_IP_PROP, SystemUtils.getHostIp());
                //+ new Random(1).nextInt(1000));
    }

}

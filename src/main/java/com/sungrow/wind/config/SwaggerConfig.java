package com.sungrow.wind.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.sungrow.wind.constant.HeaderConstant.TOKEN;

/**
 * @author GYB
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.enable}")
    private boolean enable;

    @Bean
    public Docket MyApi(){
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name(TOKEN).description("用户token").modelRef(new ModelRef("string")).parameterType("header").required(false);
        pars.add(tokenPar.build());

       /* ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("token").description("user token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数*/

        return  new Docket(DocumentationType.SWAGGER_2).enable(enable)
                .select()
                .apis(RequestHandlerSelectors.any())
                //.paths(PathSelectors.any())
                //去掉默认errorcontroller
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo());


    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("perfomance")
                .description("績效接口集")
                .version("v1")
                .build();
    }

}

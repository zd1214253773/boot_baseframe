package com.sungrow.wind.common;

import com.sungrow.wind.global.FeignResultDecoder;
import com.sungrow.wind.util.StringUtils;
import com.sungrow.wind.constant.HeaderConstant;
import com.sungrow.wind.util.StringUtils;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import java.util.Enumeration;

import static com.sungrow.wind.constant.HeaderConstant.TOKEN;

//@Configuration
public class FeignCustomizedConfiguration {

    @Bean
    public Decoder feignDecoder() {
        return new FeignResultDecoder();
    }

    @Bean
    public RequestInterceptor headerInterceptor() {
        return requestTemplate -> {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes();
            if (attributes == null) {
                return;
            }
            HttpServletRequest request = attributes.getRequest();
            String token = request.getHeader(HeaderConstant.TOKEN);
            if (!StringUtils.isEmpty(token)) {
                requestTemplate.header(HeaderConstant.TOKEN, token);
            }
            //requestTemplate.header("Host", "61.144.184.44");
            //注意压缩的问题
            Enumeration<String> enumeration = request.getHeaderNames();
            while (enumeration.hasMoreElements()) {
                String name = enumeration.nextElement();
                requestTemplate.header(name, request.getHeader(name));
            }

        };
    }
}

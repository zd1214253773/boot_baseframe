package com.sungrow.wind.global;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  private final List<RESTFulInterceptor> interceptors;

  public WebConfig(List<RESTFulInterceptor> interceptors) {
    this.interceptors = interceptors;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    interceptors.forEach(interceptor -> {
      final PathMapping mapping = interceptor.getClass().getAnnotation(PathMapping.class);
      if (mapping != null) {
        registry.addInterceptor(interceptor)
            .addPathPatterns(mapping.includes()).excludePathPatterns(mapping.excludes());
      }
    });
  }
}

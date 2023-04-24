package com.sungrow.wind.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
@EnableSpringHttpSession
@Slf4j
public class SpringSessionConfig {
  private final String sessionHeadName;

  public SpringSessionConfig(@Value("${session.head.name}") String sessionHeadName) {
    this.sessionHeadName = sessionHeadName;
  }

  //在没有用到Spring-session-redis时，需要配置spring.session.timeout
  @Bean
  public MapSessionRepository sessionRepository(@Value("${spring.session.timeout:1800}") int timeout) {
    MapSessionRepository repository = new MapSessionRepository(new ConcurrentHashMap<>());
    log.info("session设置时长：：" + timeout);
    repository.setDefaultMaxInactiveInterval(timeout);
    return repository;
  }


  @Bean
  public HttpSessionIdResolver createHttpSessionIdResolver() {
    return new HeaderHttpSessionIdResolver(sessionHeadName);
  }
}

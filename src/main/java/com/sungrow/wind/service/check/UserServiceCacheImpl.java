package com.sungrow.wind.service.check;

import com.sungrow.wind.service.cache.RefreshAble;
import com.sungrow.wind.service.cache.RefreshAble;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZHENGDONG
 * @date 2020/11/30 11:01
 */
@Service
@Slf4j
public class UserServiceCacheImpl extends RefreshAble implements UserService {

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    private Map<String, UserInfo> USER_CACHE_MAP = new ConcurrentHashMap<>();

    @Value("${sys.token.root.url}")
    private String sysUrl;

    @PostConstruct
    public void init() {
        log.info("=sysUrl======================>{}", sysUrl);
    }

    @Override
    public UserInfo token(String token) {
        return null;
//        return USER_CACHE_MAP.computeIfAbsent(token, k -> userServiceFeignClient.getUserInfo(URI.create(sysUrl), k));
    }

    @Override
    public void refresh() {
        USER_CACHE_MAP.clear();
    }
}

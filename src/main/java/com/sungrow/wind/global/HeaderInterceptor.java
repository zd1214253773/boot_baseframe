package com.sungrow.wind.global;

import com.sungrow.wind.constant.HeaderConstant;
import com.sungrow.wind.service.check.UserInfo;
import com.sungrow.wind.service.check.UserService;
import com.sungrow.wind.util.SpringBeanUtils;
import com.sungrow.wind.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZHENGDONG
 * @date 2020/11/13 15:24
 */
@Slf4j
//@Component("headerInterceptor2")
public class HeaderInterceptor implements HandlerInterceptor {

    //@Autowired
    private volatile UserService userService;

    private RequestHeader getRq(String token) {
        if (StringUtils.isEmpty(token)) {
            return RequestHeader.getDefault();
        }

        if(userService == null) {
            userService = SpringBeanUtils.getBean(UserService.class);
        }
        UserInfo userInfo = userService.token(token);
        if (userInfo != null) {
            RequestHeader header = new RequestHeader();
            header.setUserName(userInfo.getDisplayName());
//            header.setUserId(userInfo.getEmpNo());
            header.setUserId(userInfo.getUserId());
            header.setDepartmentId(userInfo.getDeptCode());
            header.setDepartName(userInfo.getDeptName());
            header.setToken(token);
            header.setHospitalId(userInfo.getOrgCode());

            return header;
        }
        return RequestHeader.getDefault();
    }

    //TODO
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(HeaderConstant.TOKEN);
        log.info("token===>{}", token);
        RequestHeader header = getRq(token);
        log.info("header===>{}", header);
        RequestHeader.addHeader(header);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        RequestHeader.removeCurrentLocal();
    }

}

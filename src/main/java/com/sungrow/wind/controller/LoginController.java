package com.sungrow.wind.controller;

import com.sungrow.wind.entity.SysFunction;
import com.sungrow.wind.entity.User;
import com.sungrow.wind.exception.BaseException;
import com.sungrow.wind.exception.BusinessException;
import com.sungrow.wind.global.data.ErrorCode;
import com.sungrow.wind.global.data.Result;
import com.sungrow.wind.global.data.UserSession;
import com.sungrow.wind.service.check.UserServiceFeignClient;
import com.sungrow.wind.util.StringUtils;
import com.sungrow.wind.vo.view.UserFunctionVO;
import com.sungrow.wind.entity.SysFunction;
import com.sungrow.wind.entity.User;
import com.sungrow.wind.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.sungrow.wind.constant.HeaderConstant.TOKEN;

@Slf4j
@Api(value = "LoginController", tags = {"LoginController"})
@RestController
public class LoginController {

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;
    @Value("${sys.token.root.url}")
    private String sysUrl;

    //@Autowired
    //private RoleService roleService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "登录")
    public Result<Map<String, String>> login(@RequestParam String systemCode, @RequestParam String ticket, HttpSession session) {
        final User user = exchangeTicket(systemCode, ticket);
        if (user == null) {
            throw new BusinessException(ErrorCode.lOGIN_ERROR.getCode(), "票据无效！");
        }
        final UserSession userSession = UserSession.fromSession(session, true);
        if (StringUtils.isEmpty(user.getDeptCode())){
            throw new BaseException(ErrorCode.LOGIN_CEHCK_ERROR);
        }
        userSession.setUser(user);
        userSession.save(session);
        return Result.success(Collections.singletonMap(TOKEN, session.getId()));
    }

    @PostMapping(value = "/login/logout")
    @ApiOperation(value = "登出")
    public Result<?> logout(HttpSession session) {
        session.invalidate();
        return Result.success();
    }

    @GetMapping(value = "/login/hasLogin")
    @ApiOperation(value = "检查是否已登录")
    public Result<?> hasLogin(HttpSession session) {
        return Result.success(UserSession.hasLogin(session));
    }


    @PostMapping(value = "/getUserFunctionAndInfo")
    @ApiOperation(value = "获取用户菜单功能和基本信息")
    public Result<UserFunctionVO> getUserFunctionAndInfo(@RequestParam String systemCode,HttpSession session) {
        UserSession userSession = UserSession.fromSession(session);
        User user = userSession.getUser();
        List<SysFunction> sysFunctions =  userServiceFeignClient.getUseRoleFunction(URI.create(sysUrl), systemCode,user.getUserName());
        UserFunctionVO userFunctionVO = new UserFunctionVO();
        //user.setDisplayName(roleService.serarchUserByDep(user.getUserId()));
        userFunctionVO.setUser(user);
        userFunctionVO.setFunctionList(sysFunctions);
        return Result.success(userFunctionVO);
    }

    private User exchangeTicket(String systemCode, String ticket) {
        User user = userServiceFeignClient.exchangeTicket(URI.create(sysUrl), systemCode,ticket);
        return user;
    }


}

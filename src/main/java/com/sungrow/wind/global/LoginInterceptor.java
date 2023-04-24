package com.sungrow.wind.global;

import com.sungrow.wind.constant.Constant;
import com.sungrow.wind.entity.User;
import com.sungrow.wind.global.data.ErrorCode;

import com.sungrow.wind.global.data.UserSession;
import com.sungrow.wind.service.DictitonaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.sungrow.wind.constant.HeaderConstant.TOKEN;

@Service
@PathMapping(includes = "/**", excludes = {"/error","/login/**", "/api/**","swagger-ui.html",
		"/swagger-resources/**","/swagger/**"})
public class LoginInterceptor extends RESTFulInterceptor {

  public static final String SESSION_NAME = "userSession";

  @Autowired
  private DictitonaryService dictitonaryService;

  @Override
  protected boolean beforeHandle(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler) throws ModelAndViewDefiningException {
    if ("tp".equals(request.getHeader(TOKEN))){ //放swagger通过，临时token
      return true;
    }
    if (!UserSession.hasLogin(request)) {
      return sendJsonError(ErrorCode.lOGIN_ERROR.getCode(), "请登录！");
    } else {
      UserSession userSession = (UserSession) request.getSession().getAttribute(SESSION_NAME);
      setRequestHeader(userSession.getUser());
      return super.beforeHandle(request, response, handler);
    }
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    RequestHeader.removeCurrentLocal();
  }


  private void setRequestHeader(User user){
    RequestHeader header = new RequestHeader();
    header.setUserName(user.getDisplayName());
    header.setUserId(user.getUserId());
    header.setDepartmentId(user.getDeptCode());
    String deptName = dictitonaryService.transferCodeToValue(user.getDeptCode(), "FUNCTION");
    header.setDepartName(deptName);
    header.setHospitalId(user.getOrgCode());
    RequestHeader.addHeader(header);
  }

}

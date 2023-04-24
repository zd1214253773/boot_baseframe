package com.sungrow.wind.global;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RESTFulInterceptor implements HandlerInterceptor {
  private final View jsonView = new MappingJackson2JsonView();

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if (!RequestMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod()) && handler instanceof HandlerMethod) {
      return beforeHandle(request, response, (HandlerMethod) handler);
    } else {
      return true;
    }
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                         @Nullable ModelAndView modelAndView) throws Exception {
    if (!RequestMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod()) && handler instanceof HandlerMethod) {
      afterHandle(request, response, (HandlerMethod) handler, modelAndView);
    }
  }

  protected boolean beforeHandle(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler) throws ModelAndViewDefiningException {
    return true;
  }

  protected void afterHandle(HttpServletRequest request, HttpServletResponse response,
                             HandlerMethod handler, ModelAndView modelAndView) {
  }

  protected boolean sendJsonError(int errorCode, String errorMsg) throws ModelAndViewDefiningException {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setView(jsonView);
    modelAndView.addObject("code", errorCode);
    modelAndView.addObject("msg", errorMsg);
    throw new ModelAndViewDefiningException(modelAndView);
  }
}
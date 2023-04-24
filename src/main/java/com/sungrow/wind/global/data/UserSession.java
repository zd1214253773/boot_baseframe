package com.sungrow.wind.global.data;

import com.sungrow.wind.entity.User;
import com.sungrow.wind.entity.User;
import lombok.Data;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@Data
public class UserSession implements Serializable {
  public static final String SESSION_NAME = "userSession";
  private User user;


  public static UserSession fromRequest(HttpServletRequest request) {
    return fromRequest(request, false);
  }

  public static UserSession fromRequest(HttpServletRequest request, boolean createIfNotExists) {
    UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, SESSION_NAME);
    if (userSession == null && createIfNotExists) {
      userSession = new UserSession();
      WebUtils.setSessionAttribute(request, SESSION_NAME, userSession);
    }
    return userSession;
  }

  public static UserSession fromSession(HttpSession session) {
    return fromSession(session, false);
  }

  public static UserSession fromSession(HttpSession session, boolean createIfNotExists) {
    UserSession userSession = (UserSession) session.getAttribute(SESSION_NAME);
    if (userSession == null && createIfNotExists) {
      userSession = new UserSession();
      session.setAttribute(SESSION_NAME, userSession);
    }
    return userSession;
  }

  public static boolean hasLogin(UserSession userSession) {
    if (userSession == null) return false;
    return userSession.user != null && userSession.user.getUserId() != null;
  }

  public static boolean hasLogin(HttpServletRequest request) {
    final UserSession userSession = fromRequest(request);
    return hasLogin((userSession));
  }

  public static boolean hasLogin(HttpSession session) {
    UserSession userSession = (UserSession) session.getAttribute(SESSION_NAME);
    return hasLogin((userSession));
  }

  public void save(HttpServletRequest request) {
    WebUtils.setSessionAttribute(request, SESSION_NAME, this);
  }

  public void save(HttpSession session) {
    session.setAttribute(SESSION_NAME, this);
  }
}

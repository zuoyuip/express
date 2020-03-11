package org.fast.express.user.security.handler;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * 登陆失败的行为.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-07 22:52
 **/
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException {
    response.setContentType("application/json;charset=utf-8");
    if (exception.fillInStackTrace().getClass().isAssignableFrom(LockedException.class)) {
      response.sendError(HttpServletResponse.SC_FORBIDDEN, "您的账户已被锁定");
      return;
    }
    if (exception.fillInStackTrace().getClass().isAssignableFrom(DisabledException.class)) {
      response.sendError(HttpServletResponse.SC_FORBIDDEN, "您的账户已被禁用");
      return;
    }
    if (exception.fillInStackTrace().getClass().isAssignableFrom(AccountExpiredException.class)) {
      response.sendError(HttpServletResponse.SC_FORBIDDEN, "您的账户已过期");
      return;
    }
    if (exception.fillInStackTrace().getClass()
        .isAssignableFrom(CredentialsExpiredException.class)) {
      response.sendError(HttpServletResponse.SC_FORBIDDEN, "您的凭证已过期");
      return;
    }
    if (exception.fillInStackTrace().getClass()
        .isAssignableFrom(InternalAuthenticationServiceException.class)) {
      response.sendError(HttpServletResponse.SC_FORBIDDEN, "登录失败，密码或帐号错误");
      return;
    }
    if (exception.fillInStackTrace().getClass().isAssignableFrom(BadCredentialsException.class)) {
      response.sendError(HttpServletResponse.SC_FORBIDDEN, "登录失败，密码或帐号错误");
      return;
    }
    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "登录功能异常");
  }
}

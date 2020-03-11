package org.fast.express.user.security.handler;

import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 登陆成功的行为.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-07 22:52
 **/
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {


  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException {
    response.setContentType("application/json;charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);
    ServletOutputStream servletOutputStream = response.getOutputStream();
    servletOutputStream.flush();
    servletOutputStream.close();
  }
}


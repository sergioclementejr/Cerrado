package com.cerradoSic.control.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizationInterceptor extends HandlerInterceptorAdapter{
  
  @Override
  public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response, Object controler)
    throws Exception {

    String uri = request.getRequestURI();
    if(uri.endsWith("loginForm") || 
          uri.endsWith("efetuaLogin") || 
              uri.contains("resources")){
      return true;
    }
    if(request.getSession().getAttribute("alunoLogado") != null) {
      return true;
    }
    
    response.sendRedirect("loginForm");
    return false;
  }
}

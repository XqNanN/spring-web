package com.nan.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 检查登陆检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
      Object user=  httpServletRequest.getSession().getAttribute("loginUser");
      if(user==null){
          httpServletRequest.setAttribute("message","没有权限访问，请先进行登陆");
          httpServletRequest.getRequestDispatcher("/").forward(httpServletRequest,httpServletResponse);
          return false;
      }else {
          return  true;
      }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

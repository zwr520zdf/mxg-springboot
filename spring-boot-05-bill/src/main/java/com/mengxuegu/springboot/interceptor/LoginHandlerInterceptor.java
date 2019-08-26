package com.mengxuegu.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser != null){
            //已登陆
            return true;
        }
        //未登录, 转发到登录页面
        request.setAttribute("msg","无权限，请登录后访问！");
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}

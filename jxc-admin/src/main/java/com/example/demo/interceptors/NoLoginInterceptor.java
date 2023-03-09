package com.example.demo.interceptors;

import com.example.demo.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器配置
 * interceptors配置后还要在config配置加入拦截器
 */
public class NoLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user=(User) request.getSession().getAttribute("user");//getAttribute设置属性
        if(null == user){
            /**
             * 未登录或登录已过期
             */
            response.sendRedirect("index");//sendRedirect重定向
            return false;
        }
        return true;
    }
}

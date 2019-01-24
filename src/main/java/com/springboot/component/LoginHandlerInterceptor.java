package com.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义权限拦截器
 *
 * @ProjectName: springboot-web1
 * @Package: com.springboot.component
 * @ClassName: LoginHandlerInterceptor
 * @Author: gnnt
 * @Date: 2019/1/24 9:17
 * @Version: 1.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = (String) request.getSession().getAttribute("username");
        if (!StringUtils.isEmpty(username)) {
//            登录
            return true;
        } else {
//            未登录
            request.getSession().setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

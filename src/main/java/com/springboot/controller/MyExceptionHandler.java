package com.springboot.controller;

import com.springboot.exception.UserNotExitException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常处理器
 *
 * @ProjectName: springboot-web1
 * @Package: com.springboot.controller
 * @ClassName: MyExceptionHandler
 * @Author: gnnt
 * @Date: 2019/1/24 16:28
 * @Version: 1.0
 */
@ControllerAdvice
public class MyExceptionHandler {

   /*   1不能自适应，浏览器和其他平台访问都返回json
   @ResponseBody
    @ExceptionHandler(UserNotExitException.class)
    public Map<String, Object> handlerException(Exception e) {
        Map<String, Object> map=new HashMap<>();
        map.put("code","user.notexist");
        map.put("message","没找到");
        return map;
    }*/

   /* 2自适应但是没有将自定义的参数封装到响应信息
   @ExceptionHandler(UserNotExitException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.notexist");
        map.put("message", "没找到");
        request.setAttribute("javax.servlet.error.status_code", 500);
        return "forward:/error";
    }*/

    @ExceptionHandler(UserNotExitException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.notexist");
        map.put("message", "没找到");
        request.setAttribute("ext", map);
        request.setAttribute("javax.servlet.error.status_code", 500);
        return "forward:/error";
    }
}

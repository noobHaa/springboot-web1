package com.springboot.controller;

import com.springboot.exception.UserNotExitException;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.Map;

/**
 * @ProjectName: springboot-web1
 * @Package: com.springboot.controller
 * @ClassName: HelloController
 * @Author: gnnt
 * @Date: 2019/1/23 14:27
 * @Version: 1.0
 */
@Controller
public class HelloController {

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("name", "nihao");
        map.put("hello", "<h1>hello</h1>");
        map.put("users", Arrays.asList("<h1>zhansan</h1>", "lis", "wangw"));
        return "success";
    }

    @RequestMapping(value = "/change",method = RequestMethod.GET)
    public String hello(String username) {
        if ("aaa".equals(username)) {
            throw new UserNotExitException();
        }
        return "login";
    }

    @RequestMapping("/test")
    public String test(){
        return "success";
    }
}

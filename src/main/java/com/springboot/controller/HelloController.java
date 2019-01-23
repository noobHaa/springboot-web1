package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        map.put("hello","<h1>hello</h1>");
        map.put("users", Arrays.asList("<h1>zhansan</h1>", "lis", "wangw"));
        return "success";
    }
}

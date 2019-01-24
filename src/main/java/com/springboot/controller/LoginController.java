package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ProjectName: springboot-web1
 * @Package: com.springboot.controller
 * @ClassName: LoginController
 * @Author: gnnt
 * @Date: 2019/1/23 17:48
 * @Version: 1.0
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession session) {

        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("username", username);
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }
}

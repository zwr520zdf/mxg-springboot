package com.mengxuegu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(HttpSession httpSession,String username, String password, Map<String, Object> map) {
        //判断用户名不为空
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            httpSession.setAttribute("loginUser",username);
            //登陆成功(转发到此页面)
            //重定向：redirect可以重定向到任意一个请求中包括其他的项目，地址栏会进行改变
            return "redirect:/main.html";
        }
        //登陆失败
        map.put("msg", "用户名或密码错误");
        return "main/login";
    }
}

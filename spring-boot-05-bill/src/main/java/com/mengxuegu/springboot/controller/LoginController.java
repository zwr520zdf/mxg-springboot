package com.mengxuegu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(String username, String password, Map<String,Object> map){
        //判断用户名不为空
        if(!StringUtils.isEmpty(username)&&"123".equals(password)){
            //登陆成功
            return "main/index";
        }
        //登陆失败
        map.put("msg","用户名或密码错误");
        return "main/login";
    }
}

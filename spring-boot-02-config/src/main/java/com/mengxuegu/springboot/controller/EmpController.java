package com.mengxuegu.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {

    //如果只是在某个业务逻辑中需要获取配置文件中的某个属性值，就使用 @Value
    @Value("${emp.last-name}")
    private String name;

    @ResponseBody
    @RequestMapping("/say")
    public String sayHello(){
        return name;
    }
}

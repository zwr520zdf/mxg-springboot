package com.mengxuegu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 供应商的控制层
 * @Author: hasee
 */
@Controller
public class ProviderController {

    @GetMapping(value = "/providers")
    public String list(){
        return "provider/list";
    }
}

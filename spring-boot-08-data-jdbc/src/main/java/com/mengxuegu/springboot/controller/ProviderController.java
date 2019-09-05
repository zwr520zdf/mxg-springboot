package com.mengxuegu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
//@Controller + @ResponseBody =  @RestController 注解 直接返回Json数据格式

@RestController
public class ProviderController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/providers")
    public Map get(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from provider");
        return maps.get(0);
    }
}

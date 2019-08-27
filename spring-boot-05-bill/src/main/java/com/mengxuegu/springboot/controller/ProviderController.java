package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.dao.ProviderDao;
import com.mengxuegu.springboot.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

/**
 * 供应商的控制层
 * @Author: hasee
 */
@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProviderDao providerDao;

    // @RequestParam(value = "providerName",required = false) 不是必须参数
    @GetMapping(value = "/providers")
    public String list(Map<String,Object> map,
                       @RequestParam(value = "providerName",required = false) String providerName){
        logger.info("供应商查询。。"+providerName);
        Collection<Provider> providers = providerDao.getAll(providerName);
        map.put("providers",providers);
        return "provider/list";
    }
}

package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.mapper.ProviderMapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    ProviderMapper providerMapper;

    @GetMapping("/provider/{pid}")
    public Provider getProvider(@PathVariable("pid") Integer pid){
       return providerMapper.getProviderByPid(pid);
    }

    @GetMapping("/provider")
    public Provider addProvider(Provider provider){
       providerMapper.addProvider(provider);
       return  provider;
    }
}

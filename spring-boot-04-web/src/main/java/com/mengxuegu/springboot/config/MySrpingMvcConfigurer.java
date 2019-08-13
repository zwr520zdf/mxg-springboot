package com.mengxuegu.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author zwr
 */
//@EnableWebMvc
@Configuration
public class MySrpingMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        // 发送 /mengxuegu 请求来到 success.html
        registry.addViewController("/mengxuegu").setViewName("success");
    }
}

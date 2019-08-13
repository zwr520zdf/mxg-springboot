package com.mengxuegu.springboot.config;

import com.mengxuegu.springboot.compent.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义配置类
 * @Configuration 进行标识
 */
@Configuration
public class MySpringMvcConfigurer {

    //  @Bean纳入容器中
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return  new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //这里main前面不要加/否则打包会出错
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("/index.html").setViewName("main/login");
            }
        };
    }

    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }
}

package com.mengxuegu.springboot.config;

import com.mengxuegu.springboot.compent.MyLocaleResolver;
import com.mengxuegu.springboot.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义配置类
 *
 * @Configuration 进行标识
 */
@Configuration
public class MySpringMvcConfigurer {

    //  @Bean纳入容器中
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //这里main前面不要加/否则打包会出错
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("/index.html").setViewName("main/login");
                registry.addViewController("/main.html").setViewName("main/index");
            }

            //添加拦截器注册到容器中
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                        .addPathPatterns("/**")     //指定拦截请求 /**表示拦截所有请求
                        .excludePathPatterns("/","/index.html","/login")    //排除不需要拦截的路径
                        .excludePathPatterns("/css/*","/img/*","/js/*"); //springboot2.0后需要手动排除静态资源的拦截
            }
        };
    }

    //区域解析器
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}

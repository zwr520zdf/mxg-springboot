package com.mengxuegu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 绑定Druid相关信息
 */
@Configuration
public class DruidConfig {

    //绑定数据源配置
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    /**
     * 配置一个druid的监控
     * 1. 配置一个druid的后台，管理servlet
     * 2. 配置一个druid的filter
     */
    //1. 配置一个druid的后台，管理servlet
    @Bean
    public ServletRegistrationBean sevlertBean(){
        //注意请求是：/druid/*
        ServletRegistrationBean servletRegistrationBean
                = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //配置初始化参数
        Map<String,String> map = new HashMap<>();
        //设置访问的账号密码
        map.put(StatViewServlet.PARAM_NAME_USERNAME,"root");
        map.put(StatViewServlet.PARAM_NAME_PASSWORD,"123");
        //设置允许访问的ip
        map.put(StatViewServlet.PARAM_NAME_ALLOW,"");
        //设置禁止访问的ip
        map.put(StatViewServlet.PARAM_NAME_DENY,"192.186.10.1");
        servletRegistrationBean.setInitParameters(map);
        return servletRegistrationBean;
    }

    //2. 配置一个druid的filter
    @Bean
    public FilterRegistrationBean webStatFilterBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        //设置使用的filter
        bean.setFilter(new WebStatFilter());
        Map<String,String> map = new HashMap<>();
        map.put(WebStatFilter.PARAM_NAME_EXCLUSIONS,"*.js,*.css,/druid/*");
        //排除请求
        bean.setInitParameters(map);
        //设置过滤的请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}

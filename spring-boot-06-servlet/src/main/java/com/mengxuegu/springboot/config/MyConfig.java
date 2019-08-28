package com.mengxuegu.springboot.config;

import com.mengxuegu.springboot.filter.MyFilter;
import com.mengxuegu.springboot.listener.Mylistener;
import com.mengxuegu.springboot.serlvet.HelloServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import java.util.Arrays;

/**
 * 注册相关组件
 */
@Configuration
public class MyConfig {

    /**
     * 注册servlet组件
     * @Bean将组件纳入容器中
     */
    @Bean
    public ServletRegistrationBean helloServlt(){
        //参数1：自定义Servlet， 参数2：url映射 (看ServletRegistrationBean构造函数)
        ServletRegistrationBean bean =
                new ServletRegistrationBean(new HelloServlet(), "/hello");
        //设置servlet组件参数配置，如下面加载顺序
        bean.setLoadOnStartup(1);
        return bean;
    }

    /**
     * 注册filter组件
     * @return
     */
    @Bean
    public FilterRegistrationBean helloFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        //设置自定义filter
        bean.setFilter(new MyFilter());
        //过滤哪些请求
        bean.setUrlPatterns(Arrays.asList("/hello","/hellos"));
        return bean;
    }

    /**
     * 注册监听器组件
     */
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean bean
                = new ServletListenerRegistrationBean(new Mylistener());

        return bean;
    }
}

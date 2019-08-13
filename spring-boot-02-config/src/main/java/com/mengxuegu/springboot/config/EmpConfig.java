package com.mengxuegu.springboot.config;

import com.mengxuegu.springboot.service.EmpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 用于标识当前类是一个配置类, 来表示对应的Spring配置文件
 */
@Configuration
public class EmpConfig {

    /**
     * @Bean 标识的方法用于向容器注入组件
     * 1. 方法的返回值就是注入容器中的组件对象, 手动创建的对象
     * 2. 方法名是这个组件对象的 id 值 同xml里bean id一样
     */
    @Bean
    public EmpService empService2(){
        System.out.println("注入成功");
        return new EmpService();
    }
}

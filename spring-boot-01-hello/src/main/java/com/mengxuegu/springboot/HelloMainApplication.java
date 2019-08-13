package com.mengxuegu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 用于引导类
 * springboot会扫描当前包及其子包下所有组件并且将这些组件加载到spring容器里面从而进行使用
 * 建立引导类时候不要放到其他子包下为了让所有组件都能扫描到
 * @SpringBootConfiguration
 *      @Configuration 属于spring中的一个注解，定义配置类，等价于配置文件
 *      @Component添加到spring容器中，表示一个组件
 * @EnableAutoConfiguration
 *      @AutoConfigurationPackage 将引导类所在包及其子包下面所有的组件扫描到Spring容器；
 *      @Import({AutoConfigurationImportSelector.class})
 *          1.将所有组件以全类名的方式返回，并且添加到spring容器中
 *          2.会给容器导入非常多的自动配置类（****AutoConfiguration),就是导入，并配置好很多当前项目需要的组件
 *          省去我门手动编配置然后注入到组件中
 *  @ComponentScan ：被该注解标识的类，会被spring容器管理
 *
 *
 */

@SpringBootApplication
public class HelloMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloMainApplication.class,args);
    }
}

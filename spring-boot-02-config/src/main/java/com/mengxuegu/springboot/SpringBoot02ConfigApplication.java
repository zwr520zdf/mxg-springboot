package com.mengxuegu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ImportResource一般标注在主配置类
 * 用于导入spring配置文件，并加载到容器中
 */
//@ImportResource(locations = {"classpath:spring01.xml"})
@SpringBootApplication
public class SpringBoot02ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02ConfigApplication.class, args);
    }

}

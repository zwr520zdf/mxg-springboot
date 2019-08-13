package com.mengxuegu.springboot02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot02Config02Application {

    public static void main(String[] args) {
        //返回module的路径 D:\SpringBootProject\spring-boot-01-hello
        //返回module路径其实获取是project创建的路径，即hello是new project出来的 其余的是new module出来的
        // 应该正确路径：D:\SpringBootProject\spring-boot-02-config-02
        System.out.println(System.getProperty("user.dir"));
        SpringApplication.run(SpringBoot02Config02Application.class, args);

//        int i=10;
//        int j=0;
//        for (i=0,j=2; i==j || 2==j; i++,j--){
//            System.out.println(j);
//        }

//        int x =1,y=1;
//        int z=(++x>++y) || (x++ >y--) ? 100 : 200;
//        System.out.println("x:"+x+" y:"+y+" z:"+z);

    }


}

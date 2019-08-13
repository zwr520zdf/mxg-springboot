package com.mengxuegu.springboot;

import com.mengxuegu.springboot.bean.Emp;
import com.mengxuegu.springboot.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {
    @Autowired
    Emp emp;

    @Autowired
    ApplicationContext context;

    //通过xml配置
    @Test
    public void testXml(){
        EmpService empService = (EmpService) context.getBean("empService");
        empService.add();
    }

    //通过注解创建配置文件
    @Test
    public void tesxZj(){
        EmpService empService = (EmpService) context.getBean("empService2");
        System.out.println("注解创建"+empService);
    }

    @Test
    public void contextLoads() {
        System.out.println(emp);
    }

}

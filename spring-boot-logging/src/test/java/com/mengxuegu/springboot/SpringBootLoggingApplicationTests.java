package com.mengxuegu.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLoggingApplicationTests {

    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {

        /*
            1. 以下日志级别，由低到高：trace < debug < info < warn < er
            2. Spring Boot默认设定的是 info 级别日志，(日志默认级别也称为root级别）
                    可修改默认级别日志：logging.level.level=级别名
            3.可以进行调整日志级别，设定某个级别后，就只打印设定的这个级别及后面高级别的日志信息
                没有指定级别的就用SpringBoot默认规定的级别：root级别
            4. 可修改指定包的日志级别：指定某个包下面的所有日志级别：logging.level.包名=级别名
         */

        //跟踪运行信息
        logger.trace("这是trace日志信息");
        //调试信息
        logger.debug("这是debug日志信息");
        //自定义信息
        logger.info("这是info日志信息");
        //警告信息
        logger.warn("这是warn日志信息");
        //错误信息
        logger.error("这是error日志信息");
    }

}

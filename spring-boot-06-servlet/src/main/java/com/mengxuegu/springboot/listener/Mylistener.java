package com.mengxuegu.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 自定义监听器
 * 测试的是关于应用的启动和关闭
 * 这里实现的是servlet监听
 */
public class Mylistener implements ServletContextListener {
    /**
     * 当Servlet 容器启动Web 应用时调用该方法。在调用完该方法之后，容器再对Filter 初始化，
     * 并且对那些在Web 应用启动时就需要被初始化的Servlet 进行初始化。
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SpringBoot.Servlet应用启动");
    }

     /**
      * 当Servlet 容器终止Web 应用时调用该方法。在调用该方法之前，容器会先销毁所有的Servlet 和Filter 过滤器。
      */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("SpringBoot.Servlet应用销毁");
    }
}

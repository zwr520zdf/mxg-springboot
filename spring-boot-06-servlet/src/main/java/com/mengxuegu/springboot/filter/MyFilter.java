package com.mengxuegu.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter过滤");
        //过滤后放行请求,其含义：过滤指定请求后放行去处理指定请求的方法，
        // 及先拦截请求，进行过滤操作，然后进行请求下的方法,
        //在myfilter里拦截的是 /hello 请求，放行后执行/hello里的方法
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("filter销毁");
    }
}

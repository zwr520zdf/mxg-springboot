package com.mengxuegu.springboot.compent;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义解析器来切换国际化信息
 * 需要注入到容器
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求头中的l参数值
        String l = httpServletRequest.getParameter("l");
        //获取浏览器上的区域信息
        Locale locale = Locale.getDefault();

        if(!StringUtils.isEmpty(l)){
            String[] spilt = l.split("_");
            //参数：语言代码，国家代码
            locale = new Locale(spilt[0],spilt[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}

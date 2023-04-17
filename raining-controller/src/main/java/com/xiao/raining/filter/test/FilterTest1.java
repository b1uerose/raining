package com.xiao.raining.filter.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 过滤器1
 * Author: xiaojl
 * Date:2023-04-12 22:35
 */
public class FilterTest1 implements Filter {
    
    public FilterTest1() {
        System.out.println("fitler无参数构造方法执行");
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init方法执行");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        System.out.println("servlet之前过滤器执行了");
        chain.doFilter(request, response);
        System.out.println("servlet之后过滤器执行了");
    }

    @Override
    public void destroy() {
        System.out.println("destory方法执行");
    }
}

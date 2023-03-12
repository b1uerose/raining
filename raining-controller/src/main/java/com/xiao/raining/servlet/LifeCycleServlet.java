package com.xiao.raining.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * servlet的生命周期
 * Author: xiaojl
 * Date:2023-03-12 10:53
 */
public class LifeCycleServlet implements Servlet {
    
    public LifeCycleServlet() {
        System.out.println("LifeCycleServlet的构造函数被调用了");
    }
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化servlet");
        ServletContext servletContext = servletConfig.getServletContext();
        
        System.out.println("servlet的名称：" + servletConfig.getServletName());
        System.out.println("=====================开始获取servlet中的参数 init-param ====================");
        Enumeration<String> params = servletConfig.getInitParameterNames();
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            System.out.println("param-name:" + paramName);
            System.out.println("param-value:" + servletConfig.getInitParameter(paramName));
        }
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException,
            IOException {

    }

    @Override
    public void destroy() {
        System.out.println("LifeCycleServlet's destory method is invoked!! 也就是说LifeCycleServlet被销毁了");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }
}
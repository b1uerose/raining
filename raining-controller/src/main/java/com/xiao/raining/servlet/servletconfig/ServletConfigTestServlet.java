package com.xiao.raining.servlet.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * servletconfig 测试
 * 一个servletconfig对应的就是web.xml中一个servlet的标签。
 * 所以可以获取
 * 1、servletname
 * 2、servlet的参数信息
 * Author: xiaojl
 * Date:2023-03-13 23:57
 */
@WebServlet(
        name = "servletconfigtest", 
        urlPatterns = {"/servletconfigtest1", "/servletconfigtest2"},
        loadOnStartup = 1, 
        initParams = {@WebInitParam(name = "copyright", value = "rain coorporation"), @WebInitParam(name = "author", value = "xiaojl")})
public class ServletConfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();

        ServletConfig servletConfig = getServletConfig();
        
        writer.print("servletconfig对象是：" + servletConfig);
        writer.print("<br>");

        String servletName = servletConfig.getServletName();
        
        writer.println("servlet的名称为：" + servletName);
        writer.print("<br>");
        
        writer.println("开始获取servlet的初始参数================");
        writer.println("<br>");

        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String param_name = initParameterNames.nextElement();
            String param_value = servletConfig.getInitParameter(param_name);
            writer.println("key:" + param_name +", value" + param_value);
            writer.print("<br>");
        }
        
    }
}
package com.xiao.raining.servlet.servletcontext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * servletcontext测试02
 * Author: xiaojl
 * Date:2023-03-15 00:14
 */
public class ServletContextTestServletB extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse reponse) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        reponse.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = reponse.getWriter();
        writer.print("B--------servletcontext对象：" + application);
        
        //获取servletcontext的属性值
        writer.println(getServletContext().getAttribute("userObj"));
        
    }
}
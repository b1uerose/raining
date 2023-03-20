package com.xiao.raining.servlet.servletcontext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * servletcontext测试01
 * Author: xiaojl
 * Date:2023-03-15 00:14
 */
public class ServletContextTestServletA extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse reponse) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        
        reponse.setContentType("text/html;charset=UTF-8");
        
        //1.获取应用的初始化参数
        PrintWriter writer = reponse.getWriter();
        writer.print("A--------servletcontext对象：" + application);
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String param_name = initParameterNames.nextElement();
            String param_value = application.getInitParameter(param_name);
            writer.println("application中，init_param:" + param_name +",value :" + param_value);
        }
        
        writer.print("</br>");
        
        //2.获取上下文和文件的绝对路径，返回 /raining
        writer.print("获取上下文路径：" + application.getContextPath());
        writer.print("</br> ");
        //2.1、返回文件的绝对路径，方法参数从应用的根开始，输出 /Users/xiao/Developer/study/raining/raining-controller/target/raining/index.jsp
        writer.print("绝对路径：");
        writer.print(application.getRealPath("index.jsp"));
        
        //3、测试servletcontext的存、取、删 
        //{key:  value: }
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("xiaojl", "肖金龙");
        getServletContext().setAttribute("userObj", userMap);
    }
}
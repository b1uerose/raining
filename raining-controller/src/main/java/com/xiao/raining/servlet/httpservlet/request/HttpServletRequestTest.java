package com.xiao.raining.servlet.httpservlet.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * httpservlet request
 * Author: xiaojl
 * Date:2023-03-25 20:23
 */
public class HttpServletRequestTest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getServletContext().getContextPath();

        String contextPath1 = request.getContextPath();

        System.out.println("引用的上下文路径：" + contextPath);
        System.out.println("引用的上下文路径1：" + contextPath1);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("url is :" + request.getRequestURL());
        System.out.println("uri is :" + request.getRequestURI());

        String servletPath = request.getServletPath();
        System.out.println(servletPath);


        //1、获取http请求协议中，用户提交的数据
        //1、根据指定的编码获取值
        String username = request.getParameter("username");
        //String hobbit = request.getParameter("hobbit");
        System.out.println(username);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<h4>用户提交的数据</h4>");
        out.print("用户名：" + username);
        out.print("<br>");

        String[] hobbits = request.getParameterValues("hobbit");
        String hobbit = Arrays.stream(hobbits).collect(Collectors.joining(",", "【", "】"));

        out.print("爱好：" + hobbit);

        out.print("<br>");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameter = parameterNames.nextElement();
            out.print(parameter);
        }

        //获取所有的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((parameterName, parameterValues) -> {
            out.print("<br>");
            out.print("参数编码：" + parameterName +"，参数值：" + String.join(",", parameterValues));
        });

    }
}
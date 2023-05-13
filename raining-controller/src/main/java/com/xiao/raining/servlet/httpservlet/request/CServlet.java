package com.xiao.raining.servlet.httpservlet.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Author: xiaojl
 * Date:2023-04-18 15:39
 */
@WebServlet("/path/c/*")
public class CServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("url:" + request.getRequestURL());
        System.out.println("uri:" + request.getRequestURI());
        System.out.println("servletPath:" + request.getServletPath());
        System.out.println("pathInfo:" + request.getPathInfo());
        
        System.out.println("queryString:" + request.getQueryString());


        System.out.println("=======");

        System.out.println("请求客户端的完整ip地址:" + request.getRemoteAddr());
        System.out.println("请求客户端的主机名称:" + request.getRemoteHost());
        System.out.println("请求客户端的端口号:" + request.getRemotePort());

        System.out.println(request.getServerName());
        System.out.println(request.getServerPort());

        System.out.println("网页从哪里来：" + request.getAttribute("Referer"));

    }
}

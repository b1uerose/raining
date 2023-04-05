package com.xiao.raining.servlet.httpservlet; 


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * httpServletTest
 * Author: xiaojl
 * Date:2023-03-19 19:43
 */
@WebServlet("/httpservlettest")
public class HttpServletTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<h1>Hello HttpServlet</h1>");

        out.print("<br>");
        String servletName = getServletConfig().getServletName();
        out.print("servlet name = " + servletName);
    }
    
}
package com.xiao.raining.servlet.httpservlet.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: xiaojl
 * Date:2023-03-26 11:17
 */
@WebServlet("/b.do")
public class BServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ////获取请求域中的值
        //Object date = request.getAttribute("date");
        //
        //response.setContentType("text/html;charset=UTF-8");
        //
        //PrintWriter writer = response.getWriter();
        //writer.print("bservlet output");
        //writer.print("date is :" + date);
        System.out.println("bservlet中的get方法执行了");

    }
}
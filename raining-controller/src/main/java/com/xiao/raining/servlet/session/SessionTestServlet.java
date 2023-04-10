package com.xiao.raining.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * session
 * Author: xiaojl
 * Date:2023-04-05 22:00
 */
@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {


    private static final long serialVersionUID = -1004211828129525040L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        out.print("session对象：" + session);
    }
}

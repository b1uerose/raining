package com.xiao.raining.servlet.httpservlet.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiao.raining.listener.test.TestBundingVo1;
import com.xiao.raining.listener.test.TestBundingVo2;

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
        //System.out.println("bservlet中的get方法执行了");

        HttpSession session = request.getSession();
        TestBundingVo1 vo1 = new TestBundingVo1();
        //request.setAttribute("vo1", vo1);
        session.setAttribute("vo1", vo1);
        
        TestBundingVo2 vo2 = new TestBundingVo2();
        //request.setAttribute("vo2", vo2);
        session.setAttribute("vo2", vo2);
        
        session.removeAttribute("vo1");
        
    }
}
package com.xiao.raining.servlet.httpservlet.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * httpservlet request测试
 * Author: xiaojl
 * Date:2023-03-26 11:17
 */
@WebServlet(urlPatterns = "/a.do", initParams = {@WebInitParam(name = "1", value = "2"), @WebInitParam(name = "2", value = "3")})
public class AServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求域
        //request.setAttribute("date", new Date());
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/b");
        //response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        //out.print("aservlet output: before forward <br>");
        //
        //requestDispatcher.include(request, response);
        //
        //out.print("<br>");
        //out.print("after forward");
        
        //请求转发，不一定是要是个servlet。可以是任务tomcat中的合法资源
        //request.getRequestDispatcher("/ui/Forward.html").forward(request, response);

        //StringBuffer requestURL = request.getRequestURL();
        //System.out.println(requestURL);
        //System.out.println(request.getRequestURI());
        //String servletPath = request.getServletPath();
        //System.out.println(servletPath);

        System.out.println(request.getQueryString());
        System.out.println(request.getPathInfo());

        //HttpSession session = request.getSession();
        //session.setAttribute("user", "xiaojl");
        //session.setAttribute("user", "sunl");
        //session.removeAttribute("user");

        //System.out.println("aservlet中的get方法执行了");
    }
}
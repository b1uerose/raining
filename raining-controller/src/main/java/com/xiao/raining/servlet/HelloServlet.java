package com.xiao.raining.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.xiao.raining.dao.query.user.UserQueryService;

/**
 * servlet测试
 * Author: xiaojl
 * Date:2023-03-11 23:45
 */
public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException,
            IOException {
        servletResponse.setContentType("text/html;chartset=UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("<h1>hello servlet</h1>");
        //查询用户
        List<Map<String, Object>> userList = new UserQueryService().queryAllUsers();

        for (Map<String, Object> userInfo : userList) {
            writer.println(userInfo.get("id") + (String)userInfo.get("vcode") + (String)userInfo.get("vname"));
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
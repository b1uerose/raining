package com.xiao.raining.servlet.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie
 * Author: xiaojl
 * Date:2023-04-07 23:20
 */
@WebServlet("/cookie/cookieTest")
public class CookieServletTest extends HttpServlet {
    
    private static final long serialVersionUID = -3456442422387158661L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("productid", "11:22:33:44");
        //cookie.setMaxAge(0);
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
    }
}

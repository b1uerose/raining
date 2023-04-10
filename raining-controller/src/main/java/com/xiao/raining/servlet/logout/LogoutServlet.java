package com.xiao.raining.servlet.logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登出
 * Author: xiaojl
 * Date:2023-04-05 23:49
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 4322866122893218047L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            //并且去掉10天内免登录

            Cookie[] cookies = request.getCookies();

            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals("isLoginInTenDays")) {
                    Cookie newCookie = new Cookie("isLoginInTenDays", "");
                    newCookie.setMaxAge(0);
                    response.addCookie(newCookie);
                }
            }
        }
        response.sendRedirect(request.getContextPath() + "/ui/login/Login.jsp");
    }
}

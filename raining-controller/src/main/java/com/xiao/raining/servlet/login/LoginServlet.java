package com.xiao.raining.servlet.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiao.raining.dao.utils.DBUtils;

/**
 * 登录
 * Author: xiaojl
 * Date:2023-04-05 16:08
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = -8918467204607250126L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String vcode = request.getParameter("vcode");
        String vpassword = request.getParameter("vpassword");
        
        //判断用户和密码是否正确
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean loginSuccess = false;
        try {
            conn = DBUtils.getConnection();
            String sql = "select 1 from bd_user where vcode = ? and vpassword = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, vcode);
            ps.setString(2, vpassword);

            rs = ps.executeQuery();
            
            if (rs.next()) {
                loginSuccess = true;
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.release(conn, ps, rs);
        }

        //跳转
        
        if (loginSuccess) {
            
            //是否十天内免登录 
            String isLoginInTenDays = request.getParameter("isLoginInTenDays");
            if (isLoginInTenDays != null && isLoginInTenDays.equals("on")) {
                Cookie cookie = new Cookie("isLoginInTenDays", vcode + "&" + vpassword);
                cookie.setPath(request.getContextPath());
                cookie.setMaxAge(10 * 24 * 60 * 60);
                response.addCookie(cookie);
            }
            request.getSession().setAttribute("isLogin", true);
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            response.sendRedirect(request.getContextPath() +"/ErrorPage.html");
        }

    }
}

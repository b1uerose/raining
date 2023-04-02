package com.xiao.raining.servlet.dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiao.raining.dao.utils.DBUtils;

/**
 * Author: xiaojl
 * Date:2023-03-31 12:52
 */
public class DeptDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("delete from bd_dept where id = ? ");
            ps.setString(1, id);
            int i = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            DBUtils.release(conn, ps, null);
        }
        String contextPath = request.getContextPath();
        String path = "/dept/deptlist";
        //request.getRequestDispatcher(path).forward(request, response);
        response.sendRedirect(contextPath + path);
    }
}

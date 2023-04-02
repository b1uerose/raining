package com.xiao.raining.servlet.dept;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiao.raining.dao.utils.DBUtils;

/**
 * 部门新增
 * Author: xiaojl
 * Date:2023-04-01 23:12
 */
public class DeptAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
       
        String vcode = request.getParameter("vcode");
        String vname = request.getParameter("vname");
        String vlocation = request.getParameter("vlocation");

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("insert into bd_dept (vcode,vname,vlocation) values (?,?,?)");
            ps.setString(1, vcode);
            ps.setString(2, vname);
            ps.setString(3, vlocation);
            ps.executeUpdate();
            
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
        
        response.sendRedirect(request.getContextPath() + "/dept/deptlist");
    }
}

package com.xiao.raining.servlet.dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiao.raining.dao.utils.DBUtils;

/**
 * 部门修改
 * Author: xiaojl
 * Date:2023-04-02 00:15
 */
public class DeptEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String id = request.getParameter("id");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String contextPath = request.getContextPath();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <title>修改部门</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>修改部门</h1>");
        out.print("<form action='"+contextPath+"/dept/deptedit' method='post'>");

        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from bd_dept where id = ? ");
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String vcode = rs.getString("vcode");
                String vname = rs.getString("vname");
                String vlocation = rs.getString("vlocation");
                out.print("    <ul>");
                out.print("        <li style='display: none;'><label for='id'>部门编号</label><input readOnly type='text' name='id' id='id' " +
                        "value='"+id +"'></li>");
                out.print("        <li><label for='vcode'>部门编号</label><input type='text' name='vcode' id='vcode' " +
                        "value='"+vcode +"'></li>");
                out.print("        <li><label for='vname'>部门名称</label><input type='text' name='vname' id='vname' " +
                        "value='"+vname+"'></li>");
                out.print("        <li><label for='vlocation'>部门位置</label><input type='text' name='vlocation' id='vlocation' " +
                        "value='"+vlocation+"'></li>");
                out.print("    </ul>");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        out.print("    <input type='submit' value='修改保存'>");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String vcode = request.getParameter("vcode");
        String vname = request.getParameter("vname");
        String vlocation = request.getParameter("vlocation");
        
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("update bd_dept set vcode = ?, vname = ?, vlocation = ? where id = ?");
            ps.setString(1, vcode);
            ps.setString(2, vname);
            ps.setString(3, vlocation);
            ps.setString(4, id);
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

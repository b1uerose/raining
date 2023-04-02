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
 * Author: xiaojl
 * Date:2023-03-30 23:10
 */
public class DeptDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String id = request.getParameter("id");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <title>部门详情</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <h1>部门详情</h1>");
        out.print("    <hr >");

        //jdbc
        //1.获取驱动
        //2.建立连接
        //3.获取数据库操作对象statement
        //4.执行sql语句
        //5.处理结果集
        //6.关闭结果集、数据库操作对象和连接

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            statement = conn.prepareStatement("select * from bd_dept where id = ? ");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String vcode = resultSet.getString("vcode");
                String vname = resultSet.getString("vname");
                String vlocation = resultSet.getString("vlocation");
                out.print("    <ul>");
                out.print("        <li>部门编码：" + vcode + "</li>");
                out.print("        <li>部门名称：" + vname + "</li>");
                out.print("        <li>部门位置：" + vlocation + "</li>");
                out.print("    </ul>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.release(conn, statement, rs);
        }
        
        out.print("");
        out.print("    <input type='button' value='返回' onclick='window.history.back()'>");
        out.print("</body>");
        out.print("</html>");


    }
}

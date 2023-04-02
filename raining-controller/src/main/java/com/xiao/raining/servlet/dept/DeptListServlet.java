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
 * 部门列表
 * Author: xiaojl
 * Date:2023-03-30 22:45
 */
public class DeptListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String contextPath = request.getContextPath();

        out.print("<!DOCTYPE html>");
        out.print("<html lang='en'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <title>部门列表</title>");
        out.print("<script type='text/javascript'>");
        out.print("function deleteDept(id) {");
        out.print("if (window.confirm('确定要删除吗')) {");
        out.print("    window.location.href = '/raining/dept/deptdelete?id='+id");
        out.print("    }");
        out.print("}");
        out.print("</script>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1 align='center'>部门列表</h1>");
        out.print("<table align='center' border='1px' width='50%'>");
        out.print("    <tr>");
        out.print("        <th>部门编码</th>");
        out.print("        <th>部门名称</th>");
        out.print("        <th>城市</th>");
        out.print("        <th>操作</th>");
        out.print("    </tr>");


        //jdbc
        //1.获取驱动
        //2.建立连接
        //3.获取数据库操作对象statement
        //4.执行sql语句
        //5.处理结果集
        //6.关闭结果集、数据库操作对象和连接

        String deptDetailURI = contextPath + "/dept/deptdetail?id=";
        String deptEditURI = contextPath +"/dept/deptedit?id=";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            statement = conn.prepareStatement("select * from bd_dept");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String vcode = resultSet.getString("vcode");
                String vname = resultSet.getString("vname");
                String vlocation = resultSet.getString("vlocation");

                out.print("    <tr>");
                out.print("        <td>" + vcode + "</td>");
                out.print("        <td>" + vname + "</td>");
                out.print("        <td>" + vlocation + "</td>");
                out.print("        <td>");
                out.print("            <a href='javascript:void(0)' onclick='deleteDept("+id+")'>删除</a>");
                out.print("            <a href='"+ deptEditURI + id +"'>修改</a>");
                out.print("            <a href='"+ deptDetailURI + id + " '>详情</a>");
                out.print("        </td>");
                out.print("    </tr>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.release(conn, statement, rs);
        }

        out.print("");
        out.print("</table>");
        out.print("");
        out.print("<a href='" + contextPath + "/ui/DEPT/AddDept.html'>新增</a>");
        out.print("</body>");
        out.print("</html>");
    }


}

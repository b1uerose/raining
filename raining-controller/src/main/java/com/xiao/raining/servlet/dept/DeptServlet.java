package com.xiao.raining.servlet.dept;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiao.raining.dao.utils.DBUtils;
import com.xiao.raining.vo.dept.DeptVO;

/**
 * 部门servlet
 * Author: xiaojl
 * Date:2023-04-05 11:01
 */
@WebServlet({"/dept/list","/dept/detail", "/dept/delete", "/dept/modify", "/dept/modifySave", "/dept/add"})
public class DeptServlet extends HttpServlet {

    private static final long serialVersionUID = 3561569764527211885L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session对象，判断是否登录。小猫咪根据JSESSIONID获取的session对象
        String servletPath = request.getServletPath();
        if ("/dept/list".equals(servletPath)) {
            //部门列表
            doList(request, response);
        } else if ("/dept/detail".equals(servletPath)) {
            //部门详情
            queryDeptDetail(request, response);
        } else if ("/dept/delete".equals(servletPath)) {
            deleteDept(request, response);
        } else if ("/dept/modify".equals(servletPath)) {
            modifyDept(request, response);
        } else if ("/dept/modifySave".equals(servletPath)) {
            modifySave(request, response);
        } else if ("/dept/add".equals(servletPath)) {
            addDept(request, response);
        } 
    }

    private void addDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        response.sendRedirect(request.getContextPath() + "/dept/list");
    }

    private void modifySave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        response.sendRedirect(request.getContextPath() + "/dept/list");
    }

    private void modifyDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DeptVO deptVo = queryDeptVo(id);
        request.setAttribute("deptVo", deptVo);
        request.getRequestDispatcher("/ui/dept/jsp/ModifyDept.jsp").forward(request, response);
    }

    private void deleteDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("delete from bd_dept where id = ? ");
            ps.setString(1, id);
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
        response.sendRedirect(request.getContextPath() +"/dept/list");
    }

    /**
     * 部门详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void queryDeptDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DeptVO deptVo = queryDeptVo(id);
        request.setAttribute("deptVo", deptVo);
        request.getRequestDispatcher("/ui/dept/jsp/DeptDetail.jsp").forward(request, response);
    }

    private DeptVO queryDeptVo(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        DeptVO deptVo = new DeptVO();
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from bd_dept where id = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String vcode = rs.getString("vcode");
                String vname = rs.getString("vname");
                String vlocation = rs.getString("vlocation");
                deptVo.setVcode(vcode);
                deptVo.setVname(vname);
                deptVo.setVlocation(vlocation);
                deptVo.setId(Integer.valueOf(id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.release(conn, ps, rs);
        }
        return deptVo;
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DeptVO> deptList = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            String sql = "select * from bd_dept ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                String vcode = rs.getString("vcode");
                String vname = rs.getString("vname");
                String vlocation = rs.getString("vlocation");
                int id = rs.getInt("id");

                DeptVO deptVo = new DeptVO();
                deptVo.setVcode(vcode);
                deptVo.setVname(vname);
                deptVo.setVlocation(vlocation);
                deptVo.setId(id);
                deptList.add(deptVo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.release(conn, ps, rs);
        }
        request.setAttribute("deptList", deptList);
        request.getRequestDispatcher("/ui/dept/jsp/DeptList.jsp").forward(request, response);
    }
}

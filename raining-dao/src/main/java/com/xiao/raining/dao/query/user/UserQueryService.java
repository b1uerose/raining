package com.xiao.raining.dao.query.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户查询服务
 * Author: xiaojl
 * Date:2023-03-12 00:01
 */
public class UserQueryService {
    
    public List<Map<String, Object>> queryAllUsers() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<Map<String, Object>> resultList = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3306/raining";
            String username = "root";
            String password = "root";
            //1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、获取链接
            conn = DriverManager.getConnection(url, username, password);
            //3、数据库操作对象
            String sql = "select id, vcode, vname from bd_user";
            ps = conn.prepareStatement(sql);
            //4、执行sql
            rs = ps.executeQuery();
            
            //5、处理结果集
            while (rs.next()) {
                int id = rs.getInt("id");
                String vcode = rs.getString("vcode");
                String vname = rs.getString("vname");
                
                //{key:  value: }
                Map<String, Object> detailMap = new HashMap<>();
                detailMap.put("id", id);
                detailMap.put("vcode", vcode);
                detailMap.put("vname", vname);
                resultList.add(detailMap);
            }
            
            return resultList;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //6、关闭连接
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        
    }
    
}
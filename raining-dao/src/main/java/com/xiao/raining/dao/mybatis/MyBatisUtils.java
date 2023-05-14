package com.xiao.raining.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Author: xiaojl
 * Date:2023-05-14 13:59
 */
public class MyBatisUtils {
    
    private static SqlSessionFactory sqlSessionFactory = null;
    
    private MyBatisUtils() {
        
    }
    
    static {
        String config = "mybatis-config.xml";
        try {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            InputStream is = Resources.getResourceAsStream(config);
            sqlSessionFactory = builder.build(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
    
    public static SqlSession getSqlSession(boolean isAutoCommit) {
        return sqlSessionFactory.openSession(isAutoCommit);
    }
    
}

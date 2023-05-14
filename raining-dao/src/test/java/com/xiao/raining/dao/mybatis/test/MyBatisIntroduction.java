package com.xiao.raining.dao.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xiao.raining.dao.mybatis.MyBatisUtils;

/**
 * Author: xiaojl
 * Date:2023-05-13 19:26
 */
public class MyBatisIntroduction {
    
    @Test
    public void myBatisIntroductionTest() throws Exception {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        try(SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            int insertCar = sqlSession.insert("insertCar");
            System.out.println("插入了" + insertCar +"条记录");
            sqlSession.commit();
        }

    }
    
}

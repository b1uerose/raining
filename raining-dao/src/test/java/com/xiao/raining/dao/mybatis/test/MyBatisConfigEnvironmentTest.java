package com.xiao.raining.dao.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xiao.raining.dao.mybatis.MyBatisUtils;

/**
 * 测试mybatis的核心配置文件。
 * Author: xiaojl
 * Date:2023-05-14 20:42
 */
public class MyBatisConfigEnvironmentTest {

    /**
     * 测试environment
     * @throws Exception
     */
    @Test
    public void testEnvironment() throws Exception {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             InputStream is2 = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory1 = builder.build(is);
            SqlSession sqlSession = factory1.openSession();
            sqlSession.insert("car.testEnvInsert");
            sqlSession.commit();
            sqlSession.close();

            SqlSessionFactory factory2 = builder.build(is2, "mybatis");
            SqlSession sqlSession2 = factory2.openSession();
            sqlSession2.insert("car.testEnvInsert");
            sqlSession2.commit();
            sqlSession2.close();
        }
    }
    
    @Test
    public void testDatasource() throws Exception {
        for (int i = 0; i < 4; i++) {
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            sqlSession.insert("car.testEnvInsert");
            sqlSession.commit();
        }   
    }
    
}

package com.xiao.raining.dao.mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.xiao.raining.dao.mybatis.MyBatisUtils;
import com.xiao.raining.vo.car.CarVO;

/**
 * Author: xiaojl
 * Date:2023-05-14 14:23
 */
public class CarMapperTest {
    
    @Test
    public void testCarInsert() throws Exception {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //{key:key  value: }
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("k1", "104");
        valueMap.put("k2", "长安福特");
        valueMap.put("k3", 12.0);
        valueMap.put("k4", "2023-09-09");
        valueMap.put("k5", "电车");
        sqlSession.insert("insertCar", valueMap);
        sqlSession.commit();
        sqlSession.close();
    }
    
    @Test
    public void testCarInsertByBean() throws Exception {
        CarVO vo = new CarVO();
        vo.setVcardno("105");
        vo.setVbrand("保时捷卡宴");
        vo.setNguideprice(93.5);
        vo.setDproducedate("2021-08-08");
        vo.setVcartype("燃油车");
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            sqlSession.insert("insertCar", vo);
            sqlSession.commit();
        }
    }
    
    @Test
    public void testDeleteCar() throws Exception {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            sqlSession.delete("deleteCarById", 5);
            sqlSession.commit();
        }
    }
    
    @Test
    public void testUpdateCarById() throws Exception {
        CarVO vo = new CarVO();
        vo.setId(13L);
        vo.setVbrand("东风标致");
        vo.setNguideprice(16.4);
        vo.setDproducedate("2016-01-01");
        vo.setVcartype("燃油车");
        vo.setVcardno("106");

        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            sqlSession.update("updateCarById", vo);
            sqlSession.commit();
        }
    }
    
    @Test
    public void testQueryCarById() throws Exception {
        long id = 13L;
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession(true)) {
            CarVO vo = sqlSession.selectOne("queryCarById", id);
            System.out.println(vo);
        }
    }
    
    @Test
    public void testCarList() throws Exception {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession(true)) {
            List<CarVO> carVos = sqlSession.selectList("queryCarList");
            for (CarVO carVo : carVos) {
                System.out.println(carVo);
            }
        }
    }
    
    @Test
    public void testMapper() throws Exception {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //sqlSession.getMapper(carmapp)
    }
}

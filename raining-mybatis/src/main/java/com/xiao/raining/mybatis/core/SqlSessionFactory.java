package com.xiao.raining.mybatis.core;

import java.util.HashMap;
import java.util.Map;

import com.xiao.raining.mybatis.core.transaction.ITransaction;
import com.xiao.raining.mybatis.core.vo.SqlMapperLabelVo;

/**
 * SqlSessionFactory
 * Author: xiaojl
 * Date:2023-05-22 22:38
 */
public class SqlSessionFactory {
    
    //事务管理器
    private ITransaction transaction;
    //数据源
    
    
    //sqlmapper
    private Map<String, SqlMapperLabelVo> mapper = new HashMap<>();
    
    
    public SqlSession openSession() {
        return null;
    }
    
}

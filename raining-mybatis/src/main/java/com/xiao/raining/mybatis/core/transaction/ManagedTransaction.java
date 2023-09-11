package com.xiao.raining.mybatis.core.transaction;

import java.sql.Connection;

/**
 * 第三方的事务管理器
 * Author: xiaojl
 * Date:2023-05-22 23:17
 */
public class ManagedTransaction implements ITransaction {
    
    @Override
    public void commit() throws Exception {
        
    }

    @Override
    public void rollBack() throws Exception {

    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public void openConnection() throws Exception {
        
    }

    @Override
    public Connection getConnection() throws Exception {
        return null;
    }
}

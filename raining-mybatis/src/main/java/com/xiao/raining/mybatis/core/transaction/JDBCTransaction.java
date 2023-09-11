package com.xiao.raining.mybatis.core.transaction;

import java.sql.Connection;

import javax.sql.DataSource;

/**
 * jdbc的事务管理器
 * Author: xiaojl
 * Date:2023-05-22 23:17
 */
public class JDBCTransaction implements ITransaction {
    
    private DataSource dataSource;
    
    private Connection connection;
    
    @Override
    public void commit() throws Exception {
        connection.commit();
    }

    @Override
    public void rollBack() throws Exception {
        connection.rollback();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public void openConnection() throws Exception {
        if (connection == null) {
            connection = dataSource.getConnection();
        }
    }

    @Override
    public Connection getConnection() throws Exception {
        return connection;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}

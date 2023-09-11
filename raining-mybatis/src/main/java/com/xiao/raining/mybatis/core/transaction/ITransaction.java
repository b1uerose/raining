package com.xiao.raining.mybatis.core.transaction;

import java.sql.Connection;

/**
 * 事务接口
 * Author: xiaojl
 * Date:2023-05-22 22:42
 */
public interface ITransaction {
    
    public void commit() throws Exception; 
    
    public void rollBack() throws Exception;
    
    public void close() throws Exception;
    
    public void openConnection() throws Exception;
    
    public Connection getConnection() throws Exception;
     
}

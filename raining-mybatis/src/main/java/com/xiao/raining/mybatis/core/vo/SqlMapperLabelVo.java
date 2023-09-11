package com.xiao.raining.mybatis.core.vo;

/**
 * mapper标签vo
 * Author: xiaojl
 * Date:2023-05-22 23:14
 */
public class SqlMapperLabelVo {
    
    private String id; //id
    private String resultType; //返回类型
    private String sql; //sql语句

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}

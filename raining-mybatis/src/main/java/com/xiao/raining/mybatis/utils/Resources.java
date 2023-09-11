package com.xiao.raining.mybatis.utils;

import java.io.InputStream;

/**
 * 资源工具类
 * Author: xiaojl
 * Date:2023-05-22 22:31
 */
public class Resources {
    
    private Resources() {
        
    }

    public static InputStream getResourceAsStream(String config) throws Exception {
        return ClassLoader.getSystemClassLoader().getResourceAsStream(config);
    }
    
}

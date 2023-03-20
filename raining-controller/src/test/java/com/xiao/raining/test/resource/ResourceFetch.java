package com.xiao.raining.test.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 3种获取资源的方式
 * Author: xiaojl
 * Date:2023-03-19 10:04
 */
public class ResourceFetch {

    public static void main(String[] args) {
        //1、第一种，返回url
        URL resource = Thread.currentThread().getContextClassLoader().getResource("test.properties");
        System.out.println(resource);
        try(InputStream is = resource.openStream()) {
            Properties prop = new Properties();
            prop.load(is);
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            System.out.println("user is :" + user + ", and password is :" + password );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        //2、第二种，返回流
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.properties")) {
            Properties prop = new Properties();
            prop.load(is);
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            System.out.println("user is :" + user + ", and password is :" + password );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        //3、第三种 资源绑定器。推荐使用
        ResourceBundle bundle = ResourceBundle.getBundle("test");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        System.out.println("user is :" + user + ", and password is :" + password);

    }
    
}
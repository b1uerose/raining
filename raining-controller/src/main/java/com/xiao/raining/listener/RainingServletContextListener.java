package com.xiao.raining.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * application监听器
 * Author: xiaojl
 * Date:2023-04-16 21:09
 */
@WebListener
public class RainingServletContextListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servletcontext创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servletcontext销毁了");
    }
}

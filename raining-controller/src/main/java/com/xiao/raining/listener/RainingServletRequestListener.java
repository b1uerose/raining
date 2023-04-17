package com.xiao.raining.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 请求监听器
 * Author: xiaojl
 * Date:2023-04-16 21:59
 */
@WebListener
public class RainingServletRequestListener implements ServletRequestListener {
    
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("创建请求");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("销毁请求");
    }
}

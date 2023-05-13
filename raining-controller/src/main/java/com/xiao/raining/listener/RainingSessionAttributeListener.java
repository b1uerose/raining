package com.xiao.raining.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * session域中的数据监听器
 * Author: xiaojl
 * Date:2023-04-17 22:32
 */
//@WebListener
public class RainingSessionAttributeListener implements HttpSessionAttributeListener {
    
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("添加属性["+event.getName()+ "]到session域中");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("移除域中的属性" + event.getName());

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("替换域中的属性[" + event.getName() +"]的值");
    }
}

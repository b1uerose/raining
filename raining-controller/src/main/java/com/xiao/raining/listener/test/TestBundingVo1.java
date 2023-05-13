package com.xiao.raining.listener.test;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Author: xiaojl
 * Date:2023-04-17 22:43
 */
public class TestBundingVo1 implements HttpSessionBindingListener {
    
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("对象被放到了session域对象中");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("对象被移出了sission域对象中");
    }
}

package com.xiao.raining.test.threadlocal;

import javax.sound.midi.Soundbank;

import org.junit.Test;

/**
 * threadlocak 测试类
 * Author: xiaojl
 * Date:2023-03-06 21:48
 */
public class ThreadLocalTest01 {
    
    private String content;
    
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public String getContent() {
        return threadLocal.get();
    }

    public void setContent(String content) {
        threadLocal.set(content);
        //this.content = content;
    }

    @Test
    public void test() throws Exception {

        ThreadLocalTest01 test = new ThreadLocalTest01();
        for (int i = 0; i < 20; i++) {
            
            Thread thread = new Thread(() -> {
                test.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println("------------------");
                System.out.println(Thread.currentThread().getName() + "->>>>>>" + test.getContent());
            }, "thread" + i);
            thread.start();
        }
        
    }
    
    
    
}
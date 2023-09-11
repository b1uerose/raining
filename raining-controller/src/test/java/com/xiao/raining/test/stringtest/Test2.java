package com.xiao.raining.test.stringtest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Author: xiaojl
 * Date:2023-03-04 23:04
 */
public class Test2 {
    
    @BeforeClass
    public static void beforeClass1() {
        System.out.println("beforeclass1");
    }

    @BeforeClass
    public static void beforeClass2() {
        System.out.println("beforeclass2");
    }
    
    @Test
    public void test1() throws Exception {
        System.out.println("test1");
    }
    
    @Test
    public void test2() throws Exception {
        System.out.println("test2");
    }
    
    @Before
    public void before1() {
        System.out.println("before1");
    }
    
    @Before
    public void before2() {
        System.out.println("before2");
    }
    
    @After
    public void after1() {
        System.out.println("after1");
    }

    @After
    public void after2() {
        System.out.println("after2");
    }

    @AfterClass
    public static void afterClass1() {
        System.out.println("afterClass1");
    }

    @AfterClass
    public static void afterClass2() {
        System.out.println("afterClass2");
    }
}
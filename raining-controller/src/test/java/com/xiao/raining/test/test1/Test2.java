package com.xiao.raining.test.test1;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date:2023-03-04 23:04
 */
public class Test2 {
    
    @Test
    public void test() throws Exception {

        String vformula = "=D2/E2";
        System.out.println(vformula.replaceAll("[0-9]+", "\\$"));
        
    }
}
package com.xiao.raining.test.inherit;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date:2023-04-03 14:50
 */
public class InheritTest {
    
    @Test
    public void Test() throws Exception {
        new ChildA().test();
        new ChildB().test();
        
        ChildA[] childArray = new ChildA[0];
        Parent[] childArray1 = (Parent[])childArray;

        System.out.println(childArray1);

    }
    
}

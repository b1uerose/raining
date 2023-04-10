package com.xiao.raining.test.collection;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date:2023-04-09 10:07
 */
public class SetTest {
    
    @Test
    public void setTest() throws Exception {
        Set<String> aSet = new HashSet<>();

        boolean b = aSet.iterator().hasNext();


        System.out.println(b);
        
        aSet.add("1");

        System.out.println(aSet.iterator().hasNext());
    }
}

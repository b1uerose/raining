package com.xiao.raining.test.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * 排序测试
 * Author: xiaojl
 * Date:2023-03-30 10:17
 */
public class SortTest01 {
    
    @Test
    public void Test() throws Exception {
        List<Integer> intList = new ArrayList<>();
        
        intList.add(1);
        intList.add(5);
        intList.add(2);
        intList.add(3);
        intList.add(6);
        intList.add(4);

        //返回值大于0正序， 小于0 降序
        Comparator<Integer> c = (a, b) -> {
            return a - b;
        };


        intList.sort(c);
        System.out.println(intList);
    }
    
}

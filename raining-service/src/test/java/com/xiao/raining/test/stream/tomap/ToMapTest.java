package com.xiao.raining.test.stream.tomap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date:2023-03-10 18:36
 */
public class ToMapTest {
    @Test
    public void test() throws Exception {
        List<Map<String, Object>> list = new ArrayList<>();  
        //{key:  value: }
        Map<String, Object> detailMap = new HashMap<>();
        detailMap.put("key", "xiaojl1");
        detailMap.put("value", 1000);
        list.add(detailMap);


        detailMap = new HashMap<>();
        detailMap.put("key", "xiaojl1");
        detailMap.put("value", 2000);
        list.add(detailMap);

        detailMap = new HashMap<>();
        detailMap.put("key", "xiaojl1");
        detailMap.put("value", 3000);
        list.add(detailMap);

        detailMap = new HashMap<>();
        detailMap.put("key", "xiaojl2");
        detailMap.put("value", 1100);
        list.add(detailMap);

        detailMap = new HashMap<>();
        detailMap.put("key", "xiaojl1");
        detailMap.put("value", 2200);
        list.add(detailMap);
        
        detailMap = new HashMap<>();
        detailMap.put("key", "xiaojl2");
        detailMap.put("value", 3300);
        list.add(detailMap);

        Map<String, Map<String, Object>> collect = list.stream().collect(Collectors.toMap(item -> (String)item.get("key"),
                Function.identity(), (a, b) -> {
            //{key:  value: }
            Map<String, Object> retMap = new HashMap<>();
            retMap.put("value", (Integer) a.get("value") + (Integer) b.get("value"));
            return retMap;
        }));

        System.out.println(collect);
    }
}
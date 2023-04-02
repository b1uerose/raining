package com.xiao.raining.test.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * stream api测试
 * Author: xiaojl
 * Date:2023-03-14 22:29
 */
public class StreamApiTest {
    
    @Test
    public void streamApiTest() throws Exception {
        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(1);
        intList.add(6);
        intList.add(4);
        intList.add(5);
        intList.add(2);
        
        //1.排序
        intList.stream().sorted(Integer::compareTo).forEach(i -> System.out.print(i +" "));

        System.out.println("");
        //获取最小值
        System.out.println("取最大值");
        intList.stream().max(Integer::compareTo).ifPresent(System.out::println);
        
        //取最小值
        System.out.println("取最小值");
        intList.stream().min(Integer::compareTo).ifPresent(System.out::println);
    }
    
    @Test
    public void streamApiDistinctTest() throws Exception {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        System.out.println(intList.stream().distinct().collect(Collectors.toList()));
    }
    
    @Test
    public void peekTest() throws Exception {
        
        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("world");
        strList.add("this");
        strList.add("is");
        
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 1)      
                .peek(e -> System.out.println("Filtered value: " + e))      
                .map(String::toUpperCase)      
                .peek(e -> System.out.println("Mapped value: " + e))      
                .collect(Collectors.toList());

    }
    
    @Test
    public void reduceTest() throws Exception {
        List<Integer> intList = new ArrayList<>();    
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        //intList.add(4);
        //intList.add(5);

        BinaryOperator<Integer> func = (a, b) -> {
            System.out.println("---------");
            System.out.println(a);
            System.out.println(b);
            return a + b;
        };

        //Integer reduce = intList.parallelStream().reduce(2, (a, b) ->  a + b, (a, b) -> a * b);
        //System.out.println(reduce);
        //Optional<Integer> reduce = intList.parallelStream().reduce(func);

        Integer reduce2 = intList.stream().reduce(1, func);
        System.out.println(reduce2);

        Optional<Integer> reduce = intList.stream().reduce(Integer::sum);
        System.out.println(reduce.get());

        Integer reduce1 = intList.stream().reduce(1, (a, b) -> a * b, (a, b) -> a * b);
        System.out.println(reduce1);
    }
    
    @Test
    public void xxxTest() throws Exception {
        List<String> strList = new LinkedList<>();
        strList.add("1111");
        strList.add("3333");
        strList.add("222");
        strList.add("455");
        strList.add("1122");
        strList.add("55678");
        strList.add("12");
        strList.add("98");

        //编译出来，是个迭代器
        for (String s : strList) {
            System.out.println(s);
        }

        for (int i = 0; i < strList.size(); i++) {
            System.out.println(strList.get(i));
        }

        //编译出来，是个fori
        String[] strings = strList.toArray(new String[0]);
        for (String string : strings) {
            System.out.println(string);
        }
    }
    
    @Test
    public void spliteratorTest() throws Exception {
        List<String> strList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            strList.add(String.valueOf(i));
        }
        
        //strList.add("1");
        //strList.add("2");
        //strList.add("3");
        //strList.add("4");
        //strList.add("5");
        //strList.add("6");
        //strList.add("7");
        //strList.add("8");
        //strList.add("9");
        //strList.add("10");

        //Spliterator<String> spliterator = strList.stream().spliterator();
        //
        //Spliterator<String> stringSpliterator = spliterator.trySplit();
        //spliterator.forEachRemaining(System.out::println);
        //stringSpliterator.forEachRemaining(System.out::println);

        long startTime = System.currentTimeMillis();
        
        
        
        strList.parallelStream().peek(a -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        //strList.parallelStream().forEach(str -> {
        //    try {
        //        Thread.sleep(1);
        //    } catch (InterruptedException e) {
        //        throw new RuntimeException(e);
        //    }
        //    System.out.println(str);
        //});
        //for (String s : strList) {
        //        try {
        //            Thread.sleep(1);
        //        } catch (InterruptedException e) {
        //            throw new RuntimeException(e);
        //        }
        //
        //    System.out.println(s);
        //}

        System.out.println("花费的时间:" + (System.currentTimeMillis() - startTime +"ms") );
    }
    
    @Test
    public void streamGroupByTest() throws Exception {
        List<Vo> voList  = getVos();
        Map<String, List<Vo>> collect = voList.stream().collect(Collectors.groupingBy(Vo::getGender));

        System.out.println(collect);
    }
    
    @Test
    public void partitionTest() throws Exception {
        List<Vo> voList = getVos();
        Map<Boolean, List<Vo>> map = voList.stream().collect(Collectors.partitioningBy(vo -> vo.getAge() > 20));

        List<Vo> vos = map.get(Boolean.FALSE);
        System.out.println(vos);
    }
    
    @Test
    public void joiningTest() throws Exception {
        List<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");
        strList.add("4");
        strList.add("5");
        strList.add("6");
        strList.add("7");

        System.out.println(strList.stream().collect(Collectors.joining(",", "[", "】")));
    }
    
    @Test
    public void toArrayTest() {
        List<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");
        strList.add("4");
        strList.add("5");
        strList.add("6");
        strList.add("7");

        String[] strings = strList.stream().filter(str -> Integer.parseInt(str) > 3).toArray(String[]::new);
    }
    
    @Test
    public void flatMapTest() throws Exception {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(Arrays.asList(1,2,3,4,5));
        }
        
        list.stream().flatMap(List::stream).filter(i -> i > 3).forEach(System.out::println);
    }
    
    private List<Vo> getVos() {
        List<Vo> List = new ArrayList<>();
        Vo vo = new Vo();
        vo.setAge(10);
        vo.setGender("male");
        vo.setName("张三");
        List.add(vo);

        vo = new Vo();
        vo.setAge(11);
        vo.setGender("male");
        vo.setName("李四");
        List.add(vo);

        vo = new Vo();
        vo.setAge(19);
        vo.setGender("female");
        vo.setName("王五");
        List.add(vo);

        vo = new Vo();
        vo.setAge(25);
        vo.setGender("male");
        vo.setName("jack");
        List.add(vo);

        vo = new Vo();
        vo.setAge(22);
        vo.setGender("female");
        vo.setName("rose");
        List.add(vo);
        return List;
    }
}

class Vo {
    private int age;
    private String name;
    private String gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return "Vo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
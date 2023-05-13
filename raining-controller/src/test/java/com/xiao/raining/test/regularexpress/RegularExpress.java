package com.xiao.raining.test.regularexpress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date:2023-04-12 17:17
 */
public class RegularExpress {
    
    @Test
    public void reTest() throws Exception {
        String vrefclass = "客商基本";
        Pattern compile = Pattern.compile("(客商)|(Custbasdoc.*RefModel)|(Custmandoc.*RefModel)");
        Matcher matcher = compile.matcher(vrefclass);
        while (matcher.find()) {
            System.out.println("!!!!!!");
        }
    }
    
    @Test
    public void reTest2() throws Exception {
        
        String pattern = "^t+es.*st$";

        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher("ttttttes is a st");

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(start + "-" + end);
            String group = matcher.group();
            System.out.println(group);
        }
    }

    /**
     * 匹配分组但不捕获
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        String data = "2023-10-01";
        Pattern compile = Pattern.compile("\\d{4}-(?:0[1-9]|1[0-2])-\\d{2}");
        Matcher matcher = compile.matcher(data);

        while (matcher.find()) {
            System.out.println(matcher.group());
            //会报错。
            //System.out.println(matcher.group(1));
        }
    }
    
    @Test
    public void _4Test() throws Exception {
        String data = "gaaa";
        
        String reg1 = "ga+";
        String reg2 = "ga.*";

        Matcher matcher = Pattern.compile(reg1).matcher(data);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        matcher = Pattern.compile(reg2).matcher(data);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }


    }
    
    
}

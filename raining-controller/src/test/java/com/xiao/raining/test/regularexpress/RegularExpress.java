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
    
    
}

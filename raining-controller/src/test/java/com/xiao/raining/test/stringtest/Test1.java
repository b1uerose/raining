package com.xiao.raining.test.stringtest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * maven test
 * Author: xiaojl
 * Date:2023-03-04 22:56
 */
public class Test1 {
    
    @Test
    public void test() throws Exception {
        System.out.println("hello");

        System.out.println("1234567890".substring(1));

        System.out.println("hello\n".trim());


        String companyOrgType = "全面所有制";
        String replacedCompanyOrgType = companyOrgType.replaceAll("\\(", "（").replaceAll("\\)", "）");
        System.out.println(replacedCompanyOrgType);
        
        String cellName = "AA11";
        System.out.println(cellName.replaceAll("\\d+", ""));

        String vfullname = "[zpl测试].[重庆中烟单位定额测试].四类烟单价";
        System.out.println(vfullname.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\\.", "/"));


        String abs = Base62.decode("xoxuxTconditionxTxhxTxkxTxdxTfieldNamexTxhxTpkxscyclexTxdxTvaluexTxhxT0001YF10000000000GZDxTxwxdxuxTconditionxTxhxTxkxTxdxTfieldNamexTxhxTpkxsdeptbgtfillxTxdxTvaluexTxhxT1001YF10000000013NDBxTxwxqx");
        System.out.println(abs);
        String field = ".";
        int index = field.indexOf(".");
        String headField = field.substring(index >= 0 ? index + 1 : 0);
        System.out.println(headField);
        
        String url = "${yytserverURI.yytfi-ys-budget}/yytfi-ys-budget/ui/FYH8/FYH808/FYH80804-index.html?billType=FY47&funCode=FYH80804"; 

        System.out.println(url.substring(url.indexOf("ui")));
        String url2 = "/yc-fi-ys-budget/ui/FYH8/FYH804/FYH80404-index.html?billType=FY40&funCode=FYH80490&isQuery=true";
        
        System.out.println(url2.substring(url2.indexOf("ui")));

    }
    
    @Test
    public void base62Test() throws Exception {
        String abs = Base62.decode("BASE62_xoxuxTconditionxTxhxTxkxTxdxTfieldNamexTxhxTaxfpkxsdeptbgtfillxTxdxTvaluexTxhxT1001YF10000000017USJxTxwxqx");
        System.out.println(abs);
    }
    
    @Test
    public void funcTest() throws Exception {
        List<String> sList = new ArrayList<>();
        sList.add("('11111','2222')");
        sList.add("('11111','2222')");
        sList.add("('11111','2222')");
        sList.add("('11111','2222')");
        sList.add("('11111','2222')");
        sList.add("('11111','2222')");
        System.out.println(String.join(",", sList));
    }
    
    @Test
    public void stringJoinTest() throws Exception {
        String str1 = "YSM";
        String str2 = "Y";

        System.out.println(String.join("", str1, str2));
    }
    
    
    
}
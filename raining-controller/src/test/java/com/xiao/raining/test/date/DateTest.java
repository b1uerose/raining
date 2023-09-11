package com.xiao.raining.test.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date:2023-08-16 15:45
 */
public class DateTest {
    
    @Test
    public void dateTest() throws Exception {
        System.out.println(getPreviousMonthDate("2023-03-31"));  
    }

    /**
     * 获取上月的这一天
     * @param date
     * @return
     */
    private String getPreviousMonthDate(String date) {
        // 获取当前日期
        LocalDate currentDate = LocalDate.parse(date);

        // 获取上一个月的日期
        LocalDate previousMonthDate = currentDate.minusMonths(1);
        // 格式化日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        String formattedDate = previousMonthDate.format(formatter);
        return formattedDate;
    }
    
}

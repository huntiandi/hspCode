package com.hsp.java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @ProjectName: com.hsp.java8
 * @author: ZhangBiBo
 * @description: 新日期API
 * @data: 2021/11/3
 */
public class TimeAPI {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        //只有日期
        System.out.println(now);
        System.out.println(now.getYear()+"年"+now.getMonthValue()+"月"+now.getDayOfMonth()+"日");
        //相当于格式化把，处理特殊日期
        LocalDate of = LocalDate.of(2020, 10, 1);
        System.out.println(of);
        //日期比较
        System.out.println(now.equals(of));


        LocalTime now1 = LocalTime.now();
        //只有时间
        System.out.println(now1);
        LocalTime localTime = now1.plusHours(2);
        //加俩小时，必须接受
        System.out.println(localTime);

        Instant now2 = Instant.now();
        //时间戳
        System.out.println(now2);
    }
}

package com.hsp.java8;

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
        System.out.println(now);
        LocalTime now1 = LocalTime.now();
        System.out.println(now1);
    }
}

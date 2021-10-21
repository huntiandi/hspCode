package com.hsp.java8;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @ProjectName: com.hsp.java8
 * @author: ZhangBiBo
 * @description: lambda表达式
 * @data: 2021/10/21
 *
 * ->左边，若只有一个参数可以去掉(),若多个参数，可以将数据类型省去，会自动判断
 * ->右边，需要使用{}:包裹，除非只有一条语句可以省略{}，去掉{}return也要去掉
 */
public class LambdaTest {
    @Test
    public void t1(){
       Runnable r1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("上海！！！！！！");
            }
        };
        r1.run();
        System.out.println("+++++++++++++++++++++");
        //由于接口只有一个方法，且没有参数，故可以将方法省略写成() ->
        Runnable r2 = () -> System.out.println("文水！！！！！！！");
        r2.run();
    }
    //需要一个参数，没有返回值
    @Test
    public void test2(){
//        Consumer<String> con = (String str) -> System.out.println("和平小区"+str);
        //数据类型可以省略。JVM会自动推断
//        Consumer<String> con = (str) -> System.out.println("和平小区"+str);
        //参数只有一个，()也可以省略
        Consumer<String> con = str -> System.out.println("和平小区"+str);
        con.accept("sss");
    }

    //需要两个参数，有返回值，多条语句执行
    @Test
    public void test3(){
        Comparator<Integer> com = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        //若只有一条语句{}和return都可以不要
        Comparator<Integer> com2 = (o1, o2) ->  o1.compareTo(o2);
        System.out.println(com.compare(11,22));
        System.out.println(com2.compare(22,11));
    }
}

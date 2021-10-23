package com.hsp.java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ProjectName: com.hsp.java8
 * @author: ZhangBiBo
 * @description: streamAPI
 * @data: 2021/10/22
 */
public class StreamTest {
    public static void main(String[] args) {
        //创建stream方式一：通过集合
        ArrayList<String> slist = new ArrayList<>();
        slist.add("中国");
        slist.add("美国");
        slist.add("法国");
        slist.add("英国");
        slist.add("泰国");
        slist.add("韩国");
        slist.add("泰国");
        //顺序流
        Stream<String> stream = slist.stream();
        //过滤，filter()中可以接受一个lambda表达式的结果
        stream.filter(str -> !str.equals("中国")).forEach(System.out::print);
        System.out.println();
        //截断，取前三个
        slist.stream().limit(3).forEach(str -> System.out.print(" "+str));
        System.out.println();
        //跳过，丢掉第n个之前的元素，如果超了，就返回一个空流
        slist.stream().skip(5).forEach(str -> System.out.print(str+""));
        System.out.println();
        //去重，可以根据重写的equals和hashcode去重
        slist.stream().distinct().forEach(str -> System.out.print(str+" "));
        //并行流
        Stream<String> stringStream = slist.parallelStream();
    }
    @Test
    public  void test1(){
        int[] ints = {1, 2, 3, 4, 5};
        //通过arrays创建一个数组的stream
        IntStream stream = Arrays.stream(ints);
        //映射，就是将原来的数据，按照规则，生成一个新的流
        stream.map(i->++i).forEach(System.out::print);
    }
    @Test
    public void test2(){
        //方式三，通过stream本身创建
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }
}

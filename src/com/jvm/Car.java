package com.jvm;

/**
 * @ProjectName: com.jvm
 * @author: ZhangBiBo
 * @description: 类加载器的测试类
 * @data: 2022/3/19
 */
public class Car {

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        System.out.println(car1.getClass());
        System.out.println(car2.getClass());
        System.out.println(car3.getClass());

        System.out.println(car1.getClass().getClassLoader());//AppClassLoader
        System.out.println(car1.getClass().getClassLoader().getParent());//getParent()找他的上一级 ExtClassLoader
        System.out.println(car1.getClass().getClassLoader().getParent().getParent());//null 1.不存在，2.调用不到  启动类是c写的，所以调用不到
    }
}

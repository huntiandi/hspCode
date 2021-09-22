package com.hsp.test;

/**
 * @ProjectName: com.hsp.test
 * @author: ZhsngBiBo
 * @description: 关于枚举
 * @data: 2021/9/22
 */
public class Enum_ {
    public static void main(String[] args) {
        //会调用Gender的父类的ENUM的toString方法(return name)
        System.out.println(Gender.BOY);
        Gender boy = Gender.BOY;
        Gender boy2 = Gender.BOY;
        System.out.println(boy == boy2);
    }
}
enum Gender{
    BOY,GIRL;
}
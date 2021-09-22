package com.hsp.test;

import com.design.template.AA;

/**
 * @ProjectName: com.hsp.test
 * @author: ZhsngBiBo
 * @description: 关于接口的一道题
 * @data: 2021/9/22
 */
public class Interface {
    public static void main(String[] args) {
        BB b = new BB();
        System.out.println(b.a);
        System.out.println(AAA.a);
        System.out.println(BB.a);//因为BB实现了AAA所以BB不实例也可以调用AAA的属性
    }
}
interface AAA {
    int a = 23;
}
interface CCC{}
interface DDD extends AAA,CCC{}//接口可以多继承接口
class  BB implements AAA {}
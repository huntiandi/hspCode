package com.hsp;

/**
 * @ProjectName: com.hsp
 * @author: ZhsngBiBo
 * @description: 代码块
 * @data: 2021/9/18
 */
public class CodeBlock {
    public static void main(String[] args) {
        new bbb();
        /*
        1.aaa的静态代码块，bbb的静态代码块，aaa的普通代码块，aaa的构造器，bbb的普通代码块，bbb的构造器
        2.先父子静，后父子普
        3.先执行父类静态代码块和静态成员按定义顺序-子类静态代码块和静态成员
        -父类普通代码块和普通成员-父类构造器-子类普通代码块和普通成员-子类构造器
         */
    }
}
class aaa{
    private static int ai =  getA();
    private int ai2 = getA2();
    {
        System.out.println("aaa的普通代码块");
    }
    static{
        System.out.println("aaa的静态代码块");
    }
    public aaa(){
        System.out.println("aaa的构造器被调用");
    }
    public static int getA(){
        System.out.println("父类静态方法");
        return 100;
    }
    public int getA2(){
        System.out.println("父类普通方法");
        return 100;
    }
}
class bbb extends aaa{
    {
        System.out.println("bbb的普通代码块");
    }

    static {
        System.out.println("bbb的静态代码块");
    }
    public bbb() {
        //super()
        //普通代码块
        System.out.println("bbb的构造器被调用");
    }
}
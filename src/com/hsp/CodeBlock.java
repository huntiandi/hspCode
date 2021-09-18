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
        2.先父后子，先静后普
         */
    }
}
class aaa{
    {
        System.out.println("aaa的普通代码块");
    }
    static{
        System.out.println("aaa的静态代码块");
    }
    public aaa(){
        System.out.println("aaa的构造器被调用");
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
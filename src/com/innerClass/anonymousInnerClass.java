package com.innerClass;

/**
 * @ProjectName: com.innerClass
 * @author: ZhsngBiBo
 * @description: 内部类-匿名内部类
 * @data: 2021/9/22
 */
public class anonymousInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
    }
}
class Outer02{
    private int n1 = 10;
    public void m1(){
        //tiger的编译类型是A 运行类型是匿名内部类 Outer02$1
        /*
        * class Outer02$1 implements A {
        *  @Override
            public void cry() {
                System.out.println("老虎叫。。。");
            }
        * }
        * */
        //创建内部类的同时创建了内部类(Outer02$1)的实例，并且把地址返回给tiger
      A tiger = new A(){
            @Override
            public void cry() {
                System.out.println("老虎叫。。。");
            }
        };
        System.out.println("tiger的运行类型 "+tiger.getClass());
      tiger.cry();

      //基于类的内部类
        Father tom = new Father("tom"){

            @Override
            public void m2() {
                System.out.println("重写m2方法");
            }
        };
        System.out.println("father的运行类型"+tom.getClass());
        tom.m2();
    }
}
interface A{
    public void cry();
}

class Father{
    public Father(String name) {

        System.out.println("接收到的名字是 "+name);
    }
    public void m2(){

    }
}
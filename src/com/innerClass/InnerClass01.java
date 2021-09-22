package com.innerClass;

/**
 * @ProjectName: com.innerClass
 * @author: ZhsngBiBo
 * @description: 内部类-局部内部类
 * @data: 2021/9/22
 */
public class InnerClass01 {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.m1();
    }
}
class Outer01{
    private int i = 10;
    public void m3(){
        System.out.println("这是外部类的方法");
    }
    public void m1(){
        class Inner01{
            private int i = 30;
            public void m2(){
                //Outer01.this本质就是Outer01的对象
                System.out.println("i的值是 " +Outer01.this.i);//重名就近原则，访问外部使用类名.this.属性
                m3();
            }

        }
        Inner01 inner01 = new Inner01();
        inner01.m2();
    }
}
package com.innerClass;

/**
 * @ProjectName: com.innerClass
 * @author: ZhsngBiBo
 * @description: 静态内部类
 * @data: 2021/9/22
 */
public class StaticInnerClass {
    public static void main(String[] args) {

        Outer04 outer04 = new Outer04();
        outer04.m41();
        //第二种方式 外部其他类访问内部类
        Outer04.Inner04 inner04 = new Outer04.Inner04();
        inner04.m4();
    }
}
class Outer04{
    private static int n1 = 40;
    public static String name = "James";
    static class Inner04{
        private static int n1 = 50;
        public void m4(){
            System.out.println("NBA球星是"+name);
            System.out.println("自己的n1是"+n1+"外部类的n1是"+Outer04.n1);
        }
    }
    public void m41(){
        Inner04 inner04 = new Inner04();
        inner04.m4();
    }
}
package com.innerClass;

/**
 * @ProjectName: com.innerClass
 * @author: ZhsngBiBo
 * @description: 成员内部类
 * @data: 2021/9/22
 */
public class MemberInnerClass {
    public static void main(String[] args) {

        Outer03 outer03 = new Outer03();
        outer03.m31();
        //将inner看做一个成员
        Outer03.Inner03 inner03 = outer03.new Inner03();
    }
}
class Outer03{
    private int n1 = 30;
    public String name = "tom";
    class Inner03{
        public void m3(){
            System.out.println("n1=" +n1+"name "+name);
        }
    }
    public void m31(){
        Inner03 inner03 = new Inner03();
        inner03.m3();
    }
}
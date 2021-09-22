package com.hsp.test;

/**
 * 错题
 * 在构造器加载时，先去找父类 ，父类调用的方法被子类重写
 * 去找子类中的方法，而此刻子类还未完成赋值初始化，所以为null
 */
public class Base {
    public String baseName = "base";

    public Base() {
        System.out.println("22222222222222222");
        callName();
    }

    public void callName() {
        System.out.println("33333333333333");
        System.out.println(baseName);
    }

    static class Sub extends Base {
        public Sub(){
            callName();
            System.out.println("=========");
        }
        private String baseName = "sub";

        public void callName() {
            System.out.println("111111111111111");
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {

        Base b = new Sub();
    }
}
package com.hsp;

public class Demo {
  class Super {
 
    String  flag = "222";
 
    Super() {
      test();
    }
 
    void test() {
      System.out.println("Super.test() flag=" + flag);
    }
  }
  class Sub extends Super {
 
    Sub( String  i) {
      flag = i;
      System.out.println("Sub.Sub()flag=" + flag);
    }
    void test() {

      System.out.println("Sub.test()flag=" + flag);
    }
  }
  public static void main(String[] args) {
    new Demo().new Sub("5");
  }
}
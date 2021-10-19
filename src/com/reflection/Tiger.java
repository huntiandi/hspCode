package com.reflection;

/**
 * @ProjectName: com.reflection
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/10/18
 */
public class Tiger {
    private String name;
    public int age = 10;

    public Tiger() {
        this.name = "大脑斧";
    }

    public Tiger(String name) {
        this.name = name;
    }

    private Tiger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void hi(String c){
        System.out.println("你好"+name+c);
    }
    public void cry(String c){
        System.out.println(name+c);
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

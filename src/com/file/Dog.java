package com.file;

import java.io.Serializable;

class Dog implements Serializable {//必须实现serializable接口
    private int age;
    private String name;
    //被static和transient(瞬时)修饰过的变量不会被序列化
    private static String color;

    //添加UID是为了提高兼容性，这样新增方法或属性就不会认为是一个新类，而只是原版本的迭代
    private static final long serializableUID = 1L;
    public Dog(int age, String name,String color) {
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}'+color;
    }
}
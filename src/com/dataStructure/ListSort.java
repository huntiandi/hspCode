package com.dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @ProjectName: com.dataStructure
 * @author: ZhangBiBo
 * @description: list集合的排序
 * @data: 2022/1/13
 */
public class ListSort {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(5);
        integers.add(2);
        integers.add(4);
        System.out.println(integers);
        Collections.sort(integers);
        System.out.println(integers);
 //------------------------list存一个对象排序-------------------------------------------------
        User user1 = new User(1);
        User user2 = new User(3);
        User user3 = new User(2);
        User user4 = new User(5);
        User user5 = new User(4);
        ArrayList<User> integers2 = new ArrayList<>();
        integers2.add(user1);
        integers2.add(user2);
        integers2.add(user3);
        integers2.add(user4);
        integers2.add(user5);
        System.out.println(integers2);
        Collections.sort(integers2);
        System.out.println(integers2);
    }
}
class User implements Comparable<User>{
    private Integer integer;

    public Integer getInteger() {
        return integer;
    }

    public User(Integer integer) {
        this.integer = integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    @Override
    public String toString() {
        return "User{" +
                "integer=" + integer +
                '}';
    }

    @Override
    public int compareTo(User o) {
        int i =this.integer-o.integer;
        return i;
    }
}
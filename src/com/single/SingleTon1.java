package com.single;

import jdk.nashorn.internal.ir.CallNode;

/**
 * @ProjectName: com.single
 * @author: ZhsngBiBo
 * @description: 单例模式-饿汉
 * @data: 2021/9/18
 */
public class SingleTon1 {
    public static void main(String[] args) {
        GirlFriend girlFriend = GirlFriend.getInstance();
        GirlFriend girlFriend2 = GirlFriend.getInstance();
        System.out.println(girlFriend);
        System.out.println(girlFriend2);
    }
}
//只能有一个女朋友
class GirlFriend {

    private String name;
    //为了能在静态方法中使用将其修饰为静态
    //在类中创建一个对象
    private static GirlFriend gf = new GirlFriend("丁");
    //保证只能有一个女朋友
    //将构造器私有化
    private GirlFriend(String name) {
        this.name = name;
    }

    //通过static(否则又要new)方法获取对象
    public static GirlFriend getInstance(){
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
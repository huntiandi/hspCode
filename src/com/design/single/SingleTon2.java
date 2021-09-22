package com.design.single;

/**
 * @ProjectName: com.design.single
 * @author: ZhsngBiBo
 * @description: 单例模式-懒汉
 *               饿汉会发生创建了但没用造成资源浪费
 * @data: 2021/9/18
 */
public class SingleTon2 {
    public static void main(String[] args) {
        //对象没创建所以构造器不会输出
        System.out.println(Dog.num);

        System.out.println("==============");
        Dog instance = Dog.getInstance();
        Dog instance2 = Dog.getInstance();

        System.out.println(instance2);
        System.out.println(instance);
        //用户调用则创建对象，后面调用则返回之前创建的对象，从而保证单例
        System.out.println(instance == instance2);
    }
}

class Dog{

    private String name;

    public static int num = 88;
    private static Dog dog;

    private Dog(String name) {
        System.out.println("構造器被調用");
        this.name = name;
    }

    public static Dog getInstance(){
        if (dog == null){//如果没有创建dog对象
          dog = new Dog("当当");
        }
        return dog;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
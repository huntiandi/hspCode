package com.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: com.reflection
 * @author: ZhangBiBo
 * @description: 模拟动态代理
 * @data: 2021/11/2
 */
public class DynamicAgent {
    public static void main (String[] args){
        SuperMan superMan = new SuperMan();
        Human proxyFactory = (Human)ProxyFactory.getProxyFactory(superMan);
        proxyFactory.eat("奥利奥");
        System.out.println(proxyFactory.getBelief());;
    }
}

interface Human{
    String getBelief();
    void eat(String food);
}

class SuperMan implements Human{
    @Override
    public String getBelief() {
        return "世界和平";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}

/**
 * 1.如何根据加载到内存中的被代理类，动态创建一个代理类及其对象
 * 2.通过代理类调用方法，如何调用被代理类同名方法
 */
class ProxyFactory{
    //解决1
    public static Object getProxyFactory(Object obj){//obj就是被代理类对象
        //handler为了解决问题2
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object obj;//需要被代理类对象赋值
    public void bind(Object obj){
        this.obj = obj;
    }
    //当通过代理类对象调用方法a就会自动的调用如下的方法：invoke（）
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method 代理类对象调用的方法，此方法也就作为被代理类对象要调用的方法
        //obj 被代理类对象
        Object value = method.invoke(obj,args);
        return  value;
    }
}
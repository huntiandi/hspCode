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

class ProxyFactory{
    public static Object getProxyFactory(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object obj;
    public void bind(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value = method.invoke(obj,args);
        return  value;
    }
}
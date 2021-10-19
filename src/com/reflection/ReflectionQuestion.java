package com.reflection;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ProjectName: com.reflection
 * @author: ZhangBiBo
 * @description: 反射
 * @data: 2021/10/18
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws Exception {
        String ProPath = "src\\com\\reflection\\re.properties";
        Properties properties = new Properties();
        //从输入字节流读取属性列表（键和元素对）。
        properties.load(new FileReader(ProPath));
        String classPath = properties.getProperty("classPath");
        String methodName = properties.getProperty("method");

        //开始反射,得到类
        Class cls = Class.forName(classPath);
        //得到类的实例
        //可能会抛出异常java.lang.InstantiationException，原因很多，有一个是没有无参构造器
        Object o = cls.newInstance();
        //通过配置文件中的方法字段，得到方法的对象
        Method method = cls.getMethod(methodName);
        //使用方法对象调用方法
        method.invoke(o);
        //拿到共有属性的值
        Field age = cls.getField("age");
        System.out.println(age.get(o));
        //拿到构造器,有参构造器要传入一个类型的class
        Constructor constructors = cls.getConstructor(String.class);
        System.out.println(constructors);
    }
}

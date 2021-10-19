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
 * Declared获取所有的构造器，方法，属性
 * setAccessible(true)爆破可以操作私有的属性方法构造器
 * 有参数要在获取的时候()中写上对应的class例如int.class
 * 静态方法或属性，可以将o替换成null
 * 在反射中，如果方法有返回值统一为object接受，但运行类型，还是方法定义的类型
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
        System.out.println(o);

        //如果只有有参构造器，那就使用下面的方法(只能拿到public的构造器),先得到对应的构造器，在传入参数
        Constructor constructor = cls.getConstructor(String.class);
        Object o1 = constructor.newInstance("东北虎");
        System.out.println(o1);

        //得到所有类型的构造器包括private的
        Constructor declaredConstructor = cls.getDeclaredConstructor(String.class,int.class);
        //爆破,使用反射可以使用private的构造器
        declaredConstructor.setAccessible(true);
        Object o2 = declaredConstructor.newInstance("剑齿虎", 100);
        System.out.println(o2);

        //通过配置文件中的方法字段，得到方法的对象
        Method method = cls.getMethod(methodName,String.class);
        //使用方法对象调用方法
//        method.invoke(o);
        method.invoke(o, "嗷嗷嗷叫");

        //拿到共有属性的值
        Field age = cls.getField("age");
        //o是对象，对哪个对象进行age的值进行设置，88是参数
        //当属性为static时，o可以写出null
        age.set(o2,88);
        System.out.println(age.get(o2)+"-"+o2);
    }
}

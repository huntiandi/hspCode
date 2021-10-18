package com.file;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @ProjectName: hspCode
 * @author: ZhangBiBo
 * @description: 对象输入输出流，需要序列化
 * @data: 2021/10/17 19:26
 */
public class ObjectIn_ {
    public static void main (String[] args) throws Exception{
    String path = "d:\\data.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeInt(100);
        oos.writeUTF("张洋大帅逼");
        oos.writeObject(new Dog(10,"当当"));
        oos.close();
    }

    @Test
    public void Read () throws Exception{
        String path2 = "d:\\data.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path2));
        System.out.println(ois.readInt());
        System.out.println(ois.readUTF());
        System.out.println(ois.readObject());
        Dog dog = (Dog) ois.readObject();
        dog.getAge();
        ois.close();
    }
}
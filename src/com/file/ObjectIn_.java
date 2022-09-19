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
        oos.writeObject(new Dog(10,"当当","白色"));
        oos.close();
    }

    @Test
    public void Read () throws Exception{
        String path2 = "d:\\data.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path2));
        System.out.println(ois.readInt());
        System.out.println(ois.readUTF());
        Dog dog = (Dog) ois.readObject();
        System.out.println(dog);
        System.out.println(dog.getAge());
        ois.close();
    }
}

class Test08 {
    public static void main(String[] args) {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))) {
            Account account = new Account();
            Account account0 = new Account();
            account.setPassword("123456");
            account.setId(2);

            oos.writeObject(account);
            oos.flush();
            account0.setPassword("456789");
            account0.setId(3);
            oos.writeObject(account0);
            //从文件依次读出两个对象
            Account account1 = (Account) ois.readObject();
            Account account2 = (Account) ois.readObject();
            //因为父类没有实现Serializable接口，所以反序列化就是新建了，那么就是默认值了
            System.out.println(account1.getPassword()+"---"+account1.getId());
            System.out.println(account2.getPassword()+"---"+account2.getId());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Account extends Base implements Serializable {
    private String password;

    private static String sex="man";

    public static String getSex() {
        return sex;
    }

    public static void setSex(String sex) {
        Account.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class Base{
    private int id ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
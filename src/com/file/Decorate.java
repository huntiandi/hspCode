package com.file;

import java.util.SplittableRandom;

/**
 * @ProjectName: com.file
 * @author: ZhangBiBo
 * @description: 模拟修饰器设计模式，也就是包装流;感觉就是动态绑定，可以操作不同的数据
 * @data: 2021/10/15
 */
public abstract class Decorate {
    public void readFile(){}
    public void readString(){}
}
class File_ extends Decorate{
    @Override
    public void readFile() {
        System.out.println("对文件进行读取");
    }
}
class String_ extends Decorate{
    @Override
    public void readString() {
        System.out.println("对字符进行读取");
    }
}
class Buffered extends Decorate{
    private Decorate decorate;

    public Buffered(Decorate decorate) {
        this.decorate = decorate;
    }

    @Override
    public void readFile() {
        decorate.readFile();
    }

    //扩展，让方法更加灵活
    public void readFile(int x) {
        for (int i = 0; i < x; i++) {
            decorate.readFile();
        }
    }

    @Override
    public void readString() {
        for (int i = 0; i < 5; i++) {
            decorate.readString();
        }
    }
}
class Test{
    public static void main(String[] args) {

        Buffered buffered = new Buffered(new File_());
        Buffered buffered2 = new Buffered(new String_());
//        buffered.readFile(4);
        buffered.readFile();
        buffered2.readString();
    }
}
package com.threads;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: 实现Runnable接口
 * @data: 2021/10/9
 */
public class Thread02_ {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Thread thread = new Thread(cat);
        thread.start();
    }
}
class Cat implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while (i<4) {
            System.out.println("当当要吃骨头"+ ++i+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
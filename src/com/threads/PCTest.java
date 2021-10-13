package com.threads;

import java.util.concurrent.ExecutorService;

/**
 * @ProjectName: hspCode
 * @author: ZhangBiBo
 * @description: 生产者，消费者的管程模式
 * @data: 2021/10/12 23:27
 */
//需要一个消费者，生产者，产品，缓冲区
public class PCTest {
    public static void main (String[] args){
        Buffer buffer = new Buffer();
        new Thread(new P(buffer)).start();
        new Thread(new C(buffer)).start();
    }
}
//缓冲区
class Buffer{
    Chicken[] chickens = new Chicken[10];
    int count = 0;
    //如果是空的将产品放入
    public synchronized void push(Chicken chicken){
        if (count == chickens.length){//容器里面已经空了
            //通知消费者等一会儿
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //通知消费者有货了
        this.notifyAll();
    }
    //如果是有货就进去拿
    public synchronized Chicken pop(){
        if (count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        Chicken chicken = chickens[count];
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.notifyAll();
        return chicken;
    }
}
//产品
class Chicken{
    private int id;

    public int getId() {
        return id;
    }

    public Chicken(int id) {
        this.id = id;
    }
}
//生产者
class P implements Runnable{
    Buffer b ;

    public P(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            b.push(new Chicken(i));
            System.out.println("生产了第"+i+"只鸡");
        }
    }
}
//消费者
class C implements Runnable{
    Buffer b ;

    public C(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Chicken chicken = b.pop();
            System.out.println("吃了编号为"+chicken.getId()+"的鸡");
        }
    }
}
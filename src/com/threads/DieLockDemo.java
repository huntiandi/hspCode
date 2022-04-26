package com.threads;

import jdk.nashorn.internal.ir.CallNode;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: 死锁实例
 * @data: 2021/10/12
 */
public class DieLockDemo {
    public static void main(String[] args) {
        Threads_ threads_ = new Threads_();
        threads_.setPool(true);
        Threads_ threads_2 = new Threads_();
        threads_2.setPool(false);
        new Thread(threads_).start();
        new Thread(threads_2).start();

    }
}

class Threads_ implements Runnable {
    static Object obj1 = new Object();
    static Object obj2 = new Object();
    private boolean pool;

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        //相当于A小孩已经有了玩具车但，还想同时拥有玩具坦克，而B小孩已经有了坦克，还想同时拿到车，所以死锁
        //所以，编写一个死锁的过程就是在第一个synchronize的代码块中再写一个同步代码块
        if (pool) {
            synchronized (obj1) {//如果为TRUE就会获得o1锁，之后尝试获取O2锁
                System.out.println("进入1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("进入2");
                }
            }
        } else {
            synchronized (obj2) {
                System.out.println("进入3");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("进入4");
                }
            }
        }
    }
}
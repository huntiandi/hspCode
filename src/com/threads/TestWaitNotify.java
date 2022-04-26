package com.threads;

import static java.lang.Thread.sleep;

public class TestWaitNotify {
    final static Object obj = new Object();
 
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (obj){
                System.out.println("执行");
                try {
                    obj.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1的其它代码...");
            }
        },"t1").start();
 
        new Thread(()->{
            synchronized (obj){
                System.out.println("执行...");
                try {
                    obj.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("其它代码...");
            }
        },"t2").start();
 
        //主线程两秒后执行
        Thread.sleep(2000);
        System.out.println("唤醒obj上其它线程");
        synchronized (obj){
//            obj.notify();
            obj.notifyAll();
        }
    }
}
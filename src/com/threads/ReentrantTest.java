package com.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: Reentrant的测试类
 * @data: 2022/4/4
 */
public class ReentrantTest {
    private static int count;
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
       /* Condition condition1 = lock.newCondition();
        Condition condition2= lock.newCondition();
        lock.lock();
        condition1.await();
        condition1.signal();*/
        Thread t1 = new Thread(()->{
         lock.lock();//上锁
         try{
         for (int i = 0; i < 500; i++) {
             count++;
         }
         }finally {
             lock.unlock();//解锁
         }
     },"t1");

     Thread t2 = new Thread(()->{
        lock.lock();
        try {
         for (int i = 0; i < 500; i++) {
             count--;
         }
        }finally {
            lock.unlock();
        }
     },"t2");

     //可打断
     Thread t3 = new Thread(()->{
         try {
             //可打断锁，获取不到锁进入阻塞但是可以被其他线程打断
             lock.lockInterruptibly();
         } catch (InterruptedException e) {
             System.out.println("阻塞了,并且被打断了未获取到锁");
             e.printStackTrace();
             return;
         }
         try{
             System.out.println("t3拿到锁了");
         }finally {
             lock.unlock();
         }
     });

     //锁超时
     Thread t4 = new Thread(()->{
         //尝试获取锁，获取到返回真没有获取到返回false
         try {
             if(lock.tryLock(500, TimeUnit.SECONDS)){//不加参数就是直接放弃，带了参数第一个是时间第二个是单位，时间到了还没有就放弃
                 try {
                     System.out.println("t4,获取到了锁");
                 }finally {
                     lock.unlock();
                 }
             }else {
                 System.out.println("t4,没有获取到锁");
             }
         } catch (InterruptedException e) {
             e.printStackTrace();
             System.out.println("获取不到 被打断");
         }
     });
    /* t1.start();
     t2.start();
     t1.join();
     t2.join();*/

        /*lock.lock();
        t3.start();
        Thread.sleep(1000);
        t3.interrupt();//如果是lock的话就无法打断会一直等下去*/

        lock.lock();
        t4.start();
        Thread.sleep(1000);
//        t4.interrupt();
        System.out.println("主线程释放锁");
        lock.unlock();
        System.out.println(count);
    }
}

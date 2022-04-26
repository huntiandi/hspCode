package com.threads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: CAS操作会出现ABA问题，例如一个线程要将A-C；在此期间有一个线程将A-B,另一个线程将B-A那么此A已经非彼A了
 * @data: 2022/4/11
 */
public class ABATest {
    private static AtomicReference<String> reference = new AtomicReference<>("A");
    //使用AtomicStampedReference解决ABA问题，添加了版本号
    private static AtomicStampedReference<String> sReference = new AtomicStampedReference<>("A",0);
    public static void main(String[] args) throws InterruptedException {
        String s = reference.get();
        String s1 = sReference.getReference();
        int stamp = sReference.getStamp();
        other();
        Thread.sleep(1000);
//        System.out.println(Thread.currentThread().getName()+"ABA--->"+ ABATest.reference.compareAndSet(s, "C"));
        System.out.println(Thread.currentThread().getName()+ "解决---》"+ABATest.sReference.compareAndSet(s1,"C",stamp,stamp+1));
    }

    public static void other(){
        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+"ABA--->"+reference.updateAndGet(str -> str = "B"));
            System.out.println(Thread.currentThread().getName()+"解决---》"+sReference.compareAndSet(sReference.getReference(),"B",sReference.getStamp(),sReference.getStamp()+1));
        },"t1").start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+"ABA--->"+reference.updateAndGet(str -> str = "A"));
            System.out.println(Thread.currentThread().getName()+"解决---》"+sReference.compareAndSet(sReference.getReference(),"A",sReference.getStamp(),sReference.getStamp()+1));

        },"t2").start();
    }
}

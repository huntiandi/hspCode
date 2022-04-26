package com.threads;

import java.time.LocalTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: Semaphore测试
 * @data: 2022/4/20
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        //参数为3就代表最多来三个线程
        Semaphore semaphore = new Semaphore(3);
        int x = 10;
        for (int i = 0; i < x; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("begin....");
                    Thread.sleep(1000);
                    System.out.println("end....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}

/**
 * CountDownLatch测试类System clipboard is unavailable
 */
class CountDownLatchTest{
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(3);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 3, 1, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2), new ThreadFactory() {
            //线程工厂，可以起个好名字
            AtomicInteger j = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"myPool_t"+j.getAndIncrement());
            }});
        pool.submit(()->{
            System.out.println(LocalTime.now()+" "+Thread.currentThread().getName()+"->begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count.countDown();
            System.out.println(LocalTime.now()+" "+Thread.currentThread().getName()+"->end");
        });
        pool.submit(()->{
            System.out.println(LocalTime.now()+" "+Thread.currentThread().getName()+"->begin");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count.countDown();
            System.out.println(LocalTime.now()+" "+Thread.currentThread().getName()+"->end");
        });
        pool.submit(()->{
            System.out.println(LocalTime.now()+" "+Thread.currentThread().getName()+"->begin");
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count.countDown();
            System.out.println(LocalTime.now()+" "+Thread.currentThread().getName()+"->end");
        });
        System.out.println(LocalTime.now()+" "+"waiting...");
        count.await();
        System.out.println(LocalTime.now()+" "+"waiting end ...");
        pool.shutdown();
    }
}

/**
 * CyclicBarrier 测试
 */
class CyclicBarrierTest{

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        CyclicBarrier barrier = new CyclicBarrier(2,()->{
            System.out.println(LocalTime.now()+" "+Thread.currentThread().getName()+"->taskAll end");
        });
        for (int i = 0; i < 3; i++) {
            pool.submit(()->{
                System.out.println(LocalTime.now()+" "+Thread.currentThread().getName()+"->task1_begin");
                try {
                    Thread.sleep(1000);
                    barrier.await();//2-1=1
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            pool.submit(()->{
                System.out.println(LocalTime.now()+" "+Thread.currentThread().getName()+"->task2_begin");
                try {
                    Thread.sleep(2000);
                    barrier.await();//1-1=0
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
    }
}
package com.threads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: 线程池简单实例
 * @data: 2021/10/14
 */
public class ThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2, new ThreadFactory() {
            //线程工厂，可以起个好名字
            AtomicInteger j = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"myPool_t"+j.getAndIncrement());
            }
        });
        Future<String> future = es.submit(() -> {
            System.out.println("有返回结果");
                Thread.sleep(1000);
            return "ok";
        });
        System.out.println(future.get());
        es.submit(()->{
            System.out.println(Thread.currentThread().getName()+"james");
        });
        es.submit(()->{
            System.out.println(Thread.currentThread().getName()+"kobe");
        });
        es.submit(() -> System.out.println("a"));
        es.shutdown();//关闭线程池
    }
}
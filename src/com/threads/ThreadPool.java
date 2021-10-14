package com.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: 线程池简单实例
 * @data: 2021/10/14
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new TpTest());
        es.submit(new TpTest());
        es.submit(new TpTest());
        es.shutdown();//关闭线程池
    }
}

class TpTest implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"giiggigi");
    }
}
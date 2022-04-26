package com.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: Fork/Join
 * @data: 2022/4/15
 */
public class ForkJoin {
    public static void main(String[] args) {
        //不带参数默认就是CPU核数
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        System.out.println(forkJoinPool.invoke(new MyTask(5)));
    }
}

/**
 * 1~n之间求和
 */
class MyTask extends RecursiveTask<Integer> {

    private int n;

    public MyTask(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "n=" + n +
                '}';
    }

    @Override
    protected Integer compute() {
        if (n == 1){
            System.out.println(Thread.currentThread().getName()+n);
            return 1;
        }
        MyTask task = new MyTask(n - 1);
        task.fork();
        System.out.println(Thread.currentThread().getName()+n+task);
        int result = n+task.join();
        return result;
    }
}
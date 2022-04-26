package com.threads;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: 自定义一个线程池 阻塞队列
 * @data: 2022/4/11
 */
public class TestPool {

    public static void main(String[] args) {
        ThreadPools threadPools = new ThreadPools(2, 1000, TimeUnit.MILLISECONDS, 2,(queue,task)->{
            //等待超时；如果什么都不写就是放弃任务；也可以直接task.run()让调用者自己调用
            queue.offer(task,1000,TimeUnit.MILLISECONDS);
        });
        for (int i = 0; i < 5; i++) {
            int j = i;
            threadPools.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"第"+j+"号");
            });
        }
    }
}
/**
 *线程池类
 */
class ThreadPools{
    //任务队列
    private BlockingQueue<Runnable> taskQueue;

    //线程集合
    private HashSet<Worker> workers = new HashSet<>();

    //核心线程数
    private int coreSize;

    //超时时间
    private long timout;

    //时间单位
    private TimeUnit timeUnit;

    //拒绝策略
    private RejectionPolicy<Runnable> reject;

    /**
     *
     * @param coreSize 核心线程数，也就是可以有几个线程
     * @param timout 超时时间
     * @param timeUnit 时间单位
     * @param size 阻塞池的大小，也就是阻塞池最多可以放多少个任务
     * @param reject 拒绝策略,用户可以自己选择如何处理等待进入队列的任务
     */
    public ThreadPools(int coreSize, long timout, TimeUnit timeUnit,int size,RejectionPolicy<Runnable> reject) {
        this.coreSize = coreSize;
        this.timout = timout;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockingQueue<>(size);
        this.reject = reject;
    }

    /**
     * 生产者传递任务给消费者，如果线程池中没有线程那么就船舰线程执行任务
     * 如果线程池中有线程，但是线程不够用那就放入阻塞池
     * @param task
     */
    public void execute(Runnable task){
       synchronized (workers){
           if (workers.size()<coreSize){
               Worker worker = new Worker(task);
               System.out.println("新增worker"+worker);
               workers.add(worker);
               worker.start();
           }else {
//               taskQueue.put(task);//死等加入队列
               //可以有更多的可能性让用户自己决定如何处理
               taskQueue.tryPut(reject,task);
           }
       }
    }

    //线程类
     class Worker extends Thread{
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
//            while (task!=null || (task = taskQueue.take()) != null){
            while (task!=null || (task = taskQueue.poll(timout,timeUnit)) != null){
                try{
                    System.out.println(task+"执行中..."+"被"+this);
                    task.run();
                }catch (Exception e){

                }finally {
                    task=null;
                }
            }
            synchronized (workers){
                System.out.println(this+"被移除");
                workers.remove(this);
            }
        }
    }
}
@FunctionalInterface
interface RejectionPolicy<T>{
    void reject(BlockingQueue<T> queue,T task);
}
//阻塞池子 存放任务，用来平衡消费者和生产者的速率
class BlockingQueue<T>{
    //一个双向链表存放阻塞的任务
    private Deque<T> deque = new ArrayDeque<>();

    /**
     * 一把锁保护线程安全，如果一个任务被多个线程获取就被重复执行了
     */
    private ReentrantLock lock = new ReentrantLock();

    //消费者等待池
    private Condition xWait = lock.newCondition();

    //生产者等待池
    private Condition sWait = lock.newCondition();

    //容量，阻塞池的大小
    private int size;

    public BlockingQueue(int size) {
        this.size = size;
    }

    public T poll(long timeout, TimeUnit unit){
        lock.lock();
        try {
            //统一单位为纳秒
            long nanos = unit.toNanos(timeout);
            while (deque.isEmpty()){
                try {
                    if (nanos<=0){
                        return null;
                    }
                    nanos = xWait.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //将第一个获取并删除
            T t = deque.removeFirst();
            sWait.signal();
            return t;
        }finally {
            lock.unlock();
        }

    }
    //获取,并且设置超时时间
    public T take(){
        lock.lock();
        try {
            while (deque.isEmpty()){
                try {
                    xWait.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //将第一个获取并删除
            T t = deque.removeFirst();
            sWait.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }
    //添加
    public void put(T task){
        lock.lock();
        try {
            while (deque.size()==size){
                try {
                    System.out.println(task +"等待加入队列");
                    sWait.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(task +"加入队列");
            deque.addLast(task);
            xWait.signal();
        }finally {
            lock.unlock();
        }
    }

    //代超时的添加方法
    public boolean offer(T task,long timeOut,TimeUnit unit){
        lock.lock();
        try {
            long nanos = unit.toNanos(timeOut);
            while (deque.size()==size){
                try {
                    if (nanos<=0){
                        return false;
                    }
                    System.out.println(task +"等待加入队列");
                    nanos = sWait.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(task +"加入队列");
            deque.addLast(task);
            xWait.signal();
            return true;
        }finally {
            lock.unlock();
        }
    }

    //获取大小,查看阻塞池还有多少任务
    public int getSize() {
        lock.lock();
        try {
            return deque.size();
        }finally {
            lock.unlock();
        }
    }

    public void tryPut(RejectionPolicy<T> rejection,T task) {
        lock.lock();
        try {
            //队列已满
            if (deque.size() == size){
                //也就时这个当前的队列要进行上面操作
                rejection.reject(this,task);
            }else {
                System.out.println(task +"加入队列");
                deque.addLast(task);
                xWait.signal();
            }
        }finally {
            lock.unlock();
        }
    }
}
package com.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: AQS原理
 * @data: 2022/4/15
 */
public class AqsTest {

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        new Thread(()->{
            try {
                myLock.lock();
                System.out.println(Thread.currentThread().getName()+System.currentTimeMillis()+"加锁");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName()+System.currentTimeMillis()+"解锁");
                myLock.unlock();
            }
        },"t1").start();
        new Thread(()->{
            try {
                myLock.lock();
                System.out.println(Thread.currentThread().getName()+System.currentTimeMillis()+"加锁");
            }finally {
                System.out.println(Thread.currentThread().getName()+System.currentTimeMillis()+"解锁");
                myLock.unlock();
            }
        },"t2").start();
    }
}

/**
 * 可重入锁
 */
class MyLock implements Lock {

    /**
     * 同步器类实现AQS,AQS会把大部分方法实现
     * 独占锁,同步器类
     */
    class MySyn extends AbstractQueuedSynchronizer{

        /**
         * 尝试获取锁
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){//保证state的原子性
                //设置锁的主人是当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //尝试释放锁
        @Override
        protected boolean tryRelease(int arg) {
            //获取锁的线程才能解锁所以不需要要cas
            setExclusiveOwnerThread(null);//在setState前保证有序性
            setState(0);
            return true;
        }

        //是否持有锁
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        //返回条件变量
        public Condition newCondition(){
            //AQS内部类可以直接使用
            return new ConditionObject();
        }
    }

    private MySyn mySyn = new MySyn();

    /**
     * 加锁(获取失败进入等待队列)
     */
    @Override
    public void lock() {
        mySyn.acquire(1);
    }

    /**
     * 可打断锁
     * @throws InterruptedException
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {
        mySyn.acquireInterruptibly(1);
    }

    /**
     * 尝试加锁(尝试一次失败就返回false)
     * @return
     */
    @Override
    public boolean tryLock() {
        return mySyn.tryAcquire(1);
    }

    /**
     * 带超时时间的尝试
     * @param time
     * @param unit
     * @return
     * @throws InterruptedException
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return mySyn.tryAcquireNanos(1,unit.toNanos(time));
    }

    /**
     * 解锁;release会先执行tryRelease再唤醒阻塞状态的线程,但是tryRelease不会唤醒阻塞状态的线程
     */
    @Override
    public void unlock() {
        mySyn.release(1);
    }

    /**
     *条件变量
     * @return
     */
    @Override
    public Condition newCondition() {
        return mySyn.newCondition();
    }

}


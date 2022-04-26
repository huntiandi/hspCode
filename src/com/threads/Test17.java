package com.threads;

/**
 * 保护性暂停;join的实现原理
 */
public class Test17 {
    public static void main(String[] args) {
        GuardedObj guardedObj = new GuardedObj();

        new Thread(()->{
            Object o = guardedObj.get(1000);
            System.out.println(Thread.currentThread().getName()+o);
        },"t1").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"下载开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            guardedObj.download();
        },"t2").start();
    }
}

class GuardedObj{
    private Object response;
    //等待结果
    public Object get(long timeout){
        synchronized (this){
        long beginTime = System.currentTimeMillis();//获取等待开始时间
        long runTime = 0;
        while (response==null){
            long waitTime = timeout-runTime;
            if (waitTime<=0){
                break;
            }
                try {
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            runTime = System.currentTimeMillis() - beginTime;//获取该线程等待时间
        }
        }
       return response;
    }

    public void download(){
        synchronized (this){
            System.out.println("正在下载。。。");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.response="张洋大帅逼";
            this.notifyAll();
        }
    }
}
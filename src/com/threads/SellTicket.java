package com.threads;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: 售票问题
 * @data: 2021/10/9
 */
public class SellTicket {
    public static void main(String[] args) {
//        Ticket1 ticket1 = new Ticket1();
//        Thread thread0 = new Thread(ticket1);
//        Thread thread1 = new Thread(ticket1);
//        Thread thread2 = new Thread(ticket1);
//        thread0.start();
//        thread1.start();
//        thread2.start();
        Ticket2 ticket2 = new Ticket2();
        Thread thread0 = new Thread(ticket2);
        Thread thread1 = new Thread(ticket2);
        Thread thread2 = new Thread(ticket2);
        thread0.start();
        thread1.start();
        thread2.start();
    }
}
class Ticket1 implements Runnable{
    public static int i = 40;
    @Override
    public void run() {
        while (i>0) {
            System.out.println(Thread.currentThread().getName() + "卖出一张票," + "剩余:" + --i+"张");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Ticket2 implements Runnable{
    public static int i = 40;

    private boolean pool =true;
    //同步机制，解决超卖问题
    public synchronized void sell(){

        if (i==0){
            pool = false;
            System.out.println("票卖光了");
            return;
        }
            System.out.println(Thread.currentThread().getName() + "卖出一张票," + "剩余:" + --i+"张");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    @Override
    public void run() {
        while (pool) {
            sell();
        }
    }
}
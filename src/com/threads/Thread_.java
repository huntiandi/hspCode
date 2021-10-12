package com.threads;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: 线程测试-继承Thread
 * @data: 2021/10/8
 */
public class Thread_ {
    public static void main(String[] args) throws InterruptedException {
        Dog dog = new Dog();
        dog.start();//启动线程-最后执行dog的run方法
        //此时主线程并不会阻塞，会继续；如果直接dog.run(),就会等run跑完，再跑下面的for
        for (int i = 0; i < 6; i++) {
            if (i==1){
                dog.join();//插队，必须等dog走完
            }
            System.out.println(i+Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}
class Dog extends Thread{

    //Thread实现了runnable接口，Thread的run方法是重写了runnable中的run方法
    @Override
    public void run() {
        int i = 0;
        while (i<4) {
            System.out.println("闪闪要吃肉"+ ++i+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
package com.threads;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: sleep方法和interrupt方法
 * @data: 2022/4/2
 */
public class Thread03 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                System.out.println("开始睡觉");
                Thread.sleep(4000);
                System.out.println("睡饱了");
            } catch (InterruptedException e) {
                System.out.println("md吵死了");
                e.printStackTrace();
            }
        },"t1");

        t.start();
        Thread.sleep(1000);
        System.out.println("我要叫醒它");
        t.interrupt();
        System.out.println("怎么睡得着");
    }
}

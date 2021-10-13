package com.threads;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: 线程通信之披萨
 * @data: 2021/10/13
 */
//生产者判断有没有披萨 如果有披萨就等待，如果没有就生产并通知消费者吃
public class PizzaThread {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        Boss boss = new Boss(pizza);
        new Thread(boss).start();
        new Thread(new Guest(pizza)).start();
    }
}
//一个披萨类
class Pizza {
    public String name;
    public boolean flag;

}

//生产者
class Boss implements Runnable{
    Pizza pizza;

    public Boss(Pizza pizza) {//由于生产者和消费者要和披萨通信且使用用一把锁，所以将披萨作为锁对象，传进来
        this.pizza = pizza;
    }

    @Override
    public void run() {
        while (true){
            synchronized (pizza){
                if (true == pizza.flag){
                    try {
                        pizza.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    pizza.name = "海陆双拼";
                    System.out.println("生产了" + pizza.name);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pizza.flag = true;
                    pizza.notify();
                }
            }
        }
    }
}

class Guest implements Runnable{
    Pizza pizza;

    public Guest(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void run() {
        while (true){
            synchronized (pizza){
                if (false == pizza.flag){
                    try {
                        pizza.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {

                    System.out.println("吃了" + pizza.name);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pizza.flag = false;
                    pizza.notify();
                }
            }
        }
    }
}
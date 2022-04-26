package com.threads;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: 两阶段终止模式
 * @data: 2022/4/4
 */
public class InterruptTest {
    private Thread monitor;

    public static void main(String[] args) throws InterruptedException {
        InterruptTest interruptTest = new InterruptTest();
        interruptTest.start();
        Thread.sleep(2200);
        interruptTest.stop();
    }
    public void start(){
       monitor = new Thread(() -> {
           Thread thread = Thread.currentThread();
           while (true){
               //判断条件也可以不使用这个打断标记，可以使用一个volatile修饰的标志，这样就不用时刻关注catch块中的代码
               if (thread.isInterrupted()){//isInterrupted和interrupted的区别就是后者会在判断后将打断标记清除
                   System.out.println("我被打断了，料理后事，后会有期");
                   break;
               }
               try {
                   Thread.sleep(300);//把这个注释掉就是正常执行代码的时候被打断了，毕竟就一行输出语句时间太短只能把sleep去掉了
                   System.out.println("我正在看着你，看着你，目不转睛");
               } catch (Exception e) {
                   System.out.println("在睡眠期间被打断了");
                   thread.interrupt();//睡眠期间会被清除标记
               }
           }
       });
       monitor.start();
    }

    public void stop(){
        monitor.interrupt();
    }
}

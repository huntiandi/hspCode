package com.threads;

import java.util.ArrayList;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: 模拟静态代理
 * @data: 2021/10/12
 */
public class StaticAgent {
    public static void main(String[] args) {
//        Marry weddingCompany = new WeddingCompany(new You());
//        weddingCompany.HappyMarry();
        //使用lamda表达式，和上面的是一样的方式，因为you只有一个核心方法
        new WeddingCompany(()-> System.out.println("结婚大喜")).HappyMarry();
        //因为Thread实现了Runnable接口，所以可以使用lamda表达式
        ArrayList<String> strings = new ArrayList<>();
       new Thread(()->{
           strings.add(Thread.currentThread().getName());
           System.out.println(strings);
       }).start();
    }

}
interface Marry{
    public void HappyMarry();
}

/*class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("今天结婚了!!!");
    }
}*/
class WeddingCompany implements Marry{
    //代理对象
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        //真正执行的是传入的目标对象，代理对象可以做一些其他的操作，真正的对象只需要做好自己的工作即可
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("完事儿，收钱！！");
    }

    private void before() {
        System.out.println("婚前准备");
    }
}
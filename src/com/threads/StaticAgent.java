package com.threads;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: 模拟静态代理
 * @data: 2021/10/12
 */
public class StaticAgent {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }

}
interface Marry{
    public void HappyMarry();
}

class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("今天结婚了!!!");
    }
}
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
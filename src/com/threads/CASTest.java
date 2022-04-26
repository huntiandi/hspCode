package com.threads;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ProjectName: com.threads
 * @author: ZhangBiBo
 * @description: 保证账户安全，通过无锁方式实现
 * @data: 2022/4/10
 */
public class CASTest {
    public static void main(String[] args) {
        Account.demo(new AccountCas(10000));
    }
}
class AccountCas implements Account {
    //使用原子整数: 底层使用CAS+重试的机制
    private AtomicInteger balance;

    private AtomicReference<String> reference;

    public AccountCas(int balance) {
        //AtomicInteger带参数的构造器中的这个int参数是被volatile修饰的保证了可见性
        this.balance = new AtomicInteger(balance);
        this.reference = new AtomicReference<>("ava");
    }

    @Override
    public Integer getBalance() {
        //得到原子整数的值
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        /*while(true) {
            //获得修改前的值
            int prev = balance.get();
            //获得修改后的值
            int next = prev - amount;
            //比较并设置值
			*//*
				此时的prev为共享变量的值, 如果prev被别的线程改了.也就是说: 自己读到的共享变量的值 和 共享变量最新值 不匹配,
				就继续where(true),如果匹配上了, 将next值设置给共享变量.

				AtomicInteger中value属性, 被volatile修饰, 就是为了确保线程之间共享变量的可见性.
			*//*
            if(balance.compareAndSet(prev, next)) {
                break;//在这一步被修改了也没事儿，应该本线程要做的已经做完了
            }
        }*/
        //可以改进为一下的方式原理就是上面的while(true);返回的是旧值,共享变量已经被改掉了
//        int andAdd = balance.getAndAdd(-1 * amount);
            balance.updateAndGet(x -> x-amount);
    }

}
interface Account {
    // 获取余额
    Integer getBalance();

    // 取款
    void withdraw(Integer amount);

    /**
     * Java8之后接口新特性, 可以添加默认方法
     * 方法内会启动 1000 个线程，每个线程做 -10 元 的操作
     * 如果初始余额为 10000 那么正确的结果应当是 0
     */
     static void demo(Account account) {
        List<Thread> ts = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(() -> {
                account.withdraw(10);
            }));
        }
        ts.forEach(thread -> thread.start());
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(account.getBalance()
                + " cost: " + (end - start) / 1000_000 + " ms");
    }
    }
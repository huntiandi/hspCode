package com.hsp.collection;

import java.util.HashSet;
import java.util.Objects;

/**
 * @ProjectName: com.hsp.collection
 * @author: ZhsngBiBo
 * @description: hashSet源码add
 * @data: 2021/9/29
 */
public class HashSet_ {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        /*
        * 1.执行add()方法
        * 2.执行put方法，key="java",value是一个object对象
        * 会执行一个hash(key)方法得到hash值，并不是hashcode会无符号位移16
        * 3.执行putVal方法，会先创建一个大小为16的Node数组，然后将hash值通过&运算为一个索引值
        * 当索引为空直接放入table，返回null在put方法中为TRUE添加成功
        * 4.该索引不为null会进行比较hash值&&（key||equals）如果成立就退出，说明第一个就是要存入的新数据
        *   否则检测该链表是否已经变为红黑树，若已经是红黑树，则按照红黑树进行比较；
        *   否则循环比较该链表的每一项，规则同第一步，如果重复直接break否则将其挂到该链最后一个
        * 5.在添加到链表后，立即判断该链表是否已达到8个节点，若达到就调用treeifBin()，对当前链表转为红黑树
        *   ps:在转为红黑树时，会进行判断，若table小于64会进行数组扩容，不会马上树化
        * */
        strings.add("java");
        strings.add("PHP");
        strings.add("java");
        System.out.println(strings);
        /*
        * hashset扩容机制,
        * 只要加入一个节点size就会加一，不是必须要在table表第一个
        * */
        HashSet<A> as = new HashSet<A>();
        for (int i = 0; i < 12; i++) {
            as.add(new A(i));
        }
    }
}
class A{
    public int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        //为了将它挂在同一个链表
        return 100;
    }
}
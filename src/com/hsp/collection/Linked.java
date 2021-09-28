package com.hsp.collection;

/**
 * @ProjectName: com.hsp.collection
 * @author: ZhangBiBo
 * @description: 模拟双向链表
 * @data: 2021/9/28
 */
public class Linked {
    public static void main(String[] args) {
        Node tom = new Node("tom");
        Node jack = new Node("jack");
        Node sims = new Node("sims");
        tom.next = jack;
        jack.next = sims;
        sims.prev = jack;
        jack.prev = tom;
        Node first = tom;
        Node last = sims;
        while (true){
            if (first == null){
                break;
            }
                System.out.println(first);
                first = first.next;//将指针下移
        }
        //添加一个节点
        Node james = new Node("james");
        james.next = sims;
        james.prev = jack;
        jack.next = james;
        sims.prev = james;
        System.out.println("添加后");
        first = tom;//重置指针
        while (true){
            if (first == null){
                break;
            }else {
                System.out.println(first);
                first = first.next;
            }
        }
    }
}
class Node{
    public Object item;
    public Node next;
    public Node prev;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
package com.hsp.collection;

/**
 * @ProjectName: com.hsp.collection
 * @author: ZhangBiBo
 * @description: 数组+链表
 * @data: 2021/9/28
 */
public class DoubleLinked {
    public static void main(String[] args) {
        Nodes[] table = new Nodes[16];
        Nodes jack = new Nodes("jack");
        table[2] = jack;
        Nodes tom = new Nodes("tom");
        jack.next = tom;//当数组大小超过64链表到8就会变成树
    }
}
class Nodes{
    public Object item;
    public Nodes next;

    public Nodes(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Nodes{" +
                "item=" + item +
                '}';
    }
}

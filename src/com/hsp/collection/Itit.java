package com.hsp.collection;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @ProjectName: com.hsp.collection
 * @author: ZhangBiBo
 * @description: 迭代器，凡是继承了iterator的都可以使用
 * @data: 2021/9/28
 */
public class Itit {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<String>();
        coll.add("jack");
        coll.add("tom");
        coll.add("james");
        Iterator<String> in = coll.iterator();
        while (in.hasNext()) {//itit快捷键
            String  next = in.next();
            System.out.println(next);
        }
        System.out.println("============");
        for (String str:coll) {//I快捷键
            System.out.println(str);
        }

    }
}

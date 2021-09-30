package com.hsp.collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @ProjectName: com.hsp.collection
 * @author: ZhsngBiBo
 * @description: treeSet
 * @data: 2021/9/30
 */
public class TreeSet_ {
    public static void main(String[] args) {
//        TreeSet<String> treeSet = new TreeSet<>();
//        通过这个内部类实现排序
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);//按字典顺序比较两个字符串
                return o1.length()-o2.length();
            }
        });
        /*
        * if (cpr != null) {//cpr就是匿名内部类
            do {
                parent = t;
                * //动态绑定到匿名内部类
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                * //如果相同就返回0这个数据就直接加入了
                    return t.setValue(value);
            } while (t != null);
        }
        *
        * */
        //Entry<K,V> t = root;t是之前已经有的对象
        //因为会拿z去比较a所在的entry(t)结果通过compare方法返回0
        //t.setValue(value);所以这时的t还是a所在的t所以z也就加入不了了
        treeSet.add("a");
        treeSet.add("z");

        treeSet.add("csr");
        treeSet.add("xss");
        System.out.println(treeSet);
    }
}

package com.hsp.collection.map;

import java.util.*;

/**
 * @ProjectName: com.hsp.collection.map
 * @author: ZhsngBiBo
 * @description: HashMap的使用
 * @data: 2021/9/30
 */
public class HashMap_ {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("主角","萧炎");//hashMap是无序的，因为key是hash算法存的
        map.put("2","萧战");
        map.put("3","萧山");
        map.put("4","萧山");
        map.put("5","萧山");
        map.put("6","萧山");
        //先得到整个entrySet，再将每一个entry取出，再取出对应的key和value
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Object o :entrySet) {
            Map.Entry<String,String> m = (Map.Entry<String, String>) o;
            System.out.println(m.getKey()+"-"+m.getValue());
        }

        System.out.println("======第二种方式=======");
        //先得到所有的key所在的set对象，然后根据迭代器，将key对应的value取出
        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next+"-"+map.get(next));
        }

        System.out.println("======第三种方式=======");
        //取出所有的value
        Collection<String> values = map.values();
        for (String str :values) {
            System.out.println(str);
        }

    }
}

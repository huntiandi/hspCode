package com.hsp.collection;

import java.util.*;

/**
 * @ProjectName: com.hsp.collection
 * @author: ZhangBiBo
 * @description: list集合的增删改查，排序，去重
 * @data: 2021/10/8
 */
public class List_ {
    public static void main(String[] args) {
        ArrayList<Integer> strings = new ArrayList<>();
        Integer[] arrays = {4, 3, 6, 5, 1};
        //新增元素
        strings.add(1);
        strings.addAll(Arrays.asList(arrays));
        System.out.println(strings);
        //指定位置新增元素
        strings.add(1, 22);
        System.out.println("指定位置插入" + strings);
        //基本数据类型进行排序，若是实体类，实体类需要实现Comparable接口重写compareTo方法
        Collections.sort(strings);
        System.out.println("排序后" + strings);
        //去重，可以借助一个set进行去重；也可以循环遍历使用list的contains方法
        /*HashSet<Integer> set = new HashSet<>();
        set.addAll(strings);
        strings.clear();
        strings.addAll(set);
        System.out.println("去重后"+strings);*/
        //删除,大于5的全部删除
        //在删除某个特定元素的时候可以使用任意一种，但需要循环删除就只能使用迭代器
        //若不使用迭代器会导致for循环删不干净；foreach报错ConcurrentModificationException
        Iterator<Integer> iterator = strings.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() > 5) {
                iterator.remove();
                //不能使用 strings.remove(iterator); 是删不掉的
            }
        }
        System.out.println("将大于5的全部删除" + strings);
        //fori当需要循环删除的时候，例如删除两个1会存在删不干净的情况，因为下标发生了变化，当你想删下标1时已经时它已经变成了0
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).equals(1)) {
                strings.remove(i);
            }
        }
        System.out.println(strings);
        //foreach 报数组下标越界
        for (Integer i : strings) {
            if (i.equals(3)) {
                strings.remove(i);
                break;
            }
        }
        //还需要注意一点，如果list中存放的时Integer类型的数据，那么在删除时需要强转，否则会导致按照你指定的数字的下标去删
        System.out.println(strings);
        strings.remove(0);
        System.out.println(strings);
        strings.remove((Integer) 5);
        System.out.println(strings);
    }
}

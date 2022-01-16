package com.dataStructure;

import java.util.Arrays;

/**
 * @ProjectName: com.dataStructure
 * @author: ZhangBiBo
 * @description: 二分查找法，查询
 * @data: 2022/1/13
 */
public class ArraySort {
    public static void main(String[] args) {
        int [] arrays = {1,6,4,3,5,2};
        Arrays.sort(arrays);
        m1(arrays,2);
        String s = "abc";
        StringBuffer sB = new StringBuffer();
        sB.append(s);
        System.out.println(sB.reverse().toString());
    }
    public static void m1 (int [] arrays,int i){
        int L = 0;
        int R = arrays.length-1;
        while (true){
            int X = (L+R)/2;
            if (L>R){
                System.out.println("不存在");
                return ;
            }
            if (arrays[X] == i){
                System.out.println("找到了下标为"+X+"数字是"+arrays[X]);
                return ;
            }else if(arrays[X]>i){
                R = X -1;
            }else if(arrays[X]<i){
                L = X+1;
            }
        }
    }
}

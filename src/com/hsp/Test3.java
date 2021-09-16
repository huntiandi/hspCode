package com.hsp;

/**
 * @ProjectName: WorkSpace
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/9/14 10:00
 */
public class Test3 {
    public static void main(String[] args) {
        int[] array ={1,2,3};
        n(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }

    }

    public static void n (int[] names){
        names[0] = 0;
    }
}

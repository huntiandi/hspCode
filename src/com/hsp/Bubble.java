package com.hsp;

/**
 * @ProjectName: WorkSpace
 * @author: ZhangBiBo
 * @description: 冒泡排序
 * @data: 2021/9/10 10:35
 */
public class Bubble {
    public static void main(String[] args) {
        int[] array = {11,1, 2, 9, 3, 8, 4,0};
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {//排序轮数
            for (int j = 0; j < array.length - 1 - i; j++) {//每一轮排序次数
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
    }
}

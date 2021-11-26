package com.dataStructure.stack;

/**
 * @ProjectName: com.dataStructure.stack
 * @author: ZhangBiBo
 * @description: 队列的基本使用
 * @data: 2021/11/26
 */
public class MyQueue {
    //队列底层使用数组存放
    int[] elements;

    public MyQueue() {
        elements = new int[0];
    }

    //入队
    public void push(int element){
        //创建一个新数组
        int[] newArry = new int[elements.length + 1];
        //将旧数据存放进去
        for (int i = 0; i < elements.length; i++) {
            newArry[i] = elements[i];
        }
        //将新传入的数据传入
        newArry[elements.length]=element;
        //将新数组代替旧数组
        elements = newArry;
    }

    //出队
    public int pop(){
        if (elements.length==0){
            throw new RuntimeException("队列为空");
        }
        int element = elements[0];
        int[] newArr = new int[elements.length - 1];
        //替换数组，将第一个元素去掉
        for (int i = 0; i < elements.length - 1; i++) {
            newArr[i] = elements[i+1];
        }
        //替换数组
        elements = newArr;
        return element;
    }
}

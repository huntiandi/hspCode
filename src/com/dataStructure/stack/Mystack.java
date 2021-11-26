package com.dataStructure.stack;

/**
 * @ProjectName: com.dataStructure.stack
 * @author: ZhangBiBo
 * @description: 栈的假单实现
 * @data: 2021/11/26
 */
public class Mystack {
    //栈底层使用数组存放
    int[] elements;

    public Mystack() {
        elements = new int[0];
    }

    //压入元素
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

    //取出栈顶元素
    public int pop(){
        if (elements.length==0){
            throw new RuntimeException("栈为空");
        }
        int element = elements[elements.length-1];
        int[] newArr = new int[elements.length - 1];
        //将原数组中除了最后一个数据，放入新的数组
        for (int i = 0; i < elements.length - 1; i++) {
            newArr[i] = elements[i];
        }
        //替换数组
        elements = newArr;
        return element;
    }

    //查看栈顶元素
    public int pep(){
        if (elements.length==0){
            throw new RuntimeException("栈为空");
        }
        return elements[elements.length-1];
    }

    //判断非空
    public boolean isEmpty(){
        return elements.length==0;
    }
}

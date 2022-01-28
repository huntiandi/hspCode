package com.dataStructure;

import com.dataStructure.stack.MyQueue;
import com.dataStructure.stack.Mystack;
import org.junit.jupiter.api.Test;

/**
 * @ProjectName: com.dataStructure
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/11/26
 */
class MystackTest {

    public static void main(String[] args) {
        //栈测试
        Mystack ms = new Mystack();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
//        System.out.println(ms.pep());
        System.out.println(ms.isEmpty());

    }

    @Test
    public void MyQueueTest(){
        //队列测试
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        myQueue.push(4);
        System.out.println(myQueue.pop());
    }
}
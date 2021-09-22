package com.design.template;

/**
 * @ProjectName: com.design.template
 * @author: ZhsngBiBo
 * @description: 模板设计模式
 * @data: 2021/9/22
 */
abstract public class Template {

   abstract public void job();

   public void calculateTime(){
       long start = System.currentTimeMillis();
       job();//动态绑定
       long end = System.currentTimeMillis();
       System.out.println("执行时间"+(end-start));
   }
}

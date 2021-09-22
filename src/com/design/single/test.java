package com.design.single;

/**
 * @ProjectName: com.design.single
 * @author: ZhsngBiBo
 * @description: 单例模式练习
 * @data: 2021/9/18
 */
public class test {
    private static int i = 1;
    public static void main(String[] args) {
        tttt t1 = tttt.getT1();
        System.out.println(t1);
    }
}
class tttt {
    private String name;

    private static int i = 1;
//    private static tttt t1= new tttt("nnnn");
    private static tttt t1;
    private tttt(String name) {
        this.name = name;
    }

//    public static tttt getT1(){
//        return t1;
//    }
    public static tttt getT1(){
        if (t1 == null){
            t1 = new tttt("nnnn");
        }
        return t1;
    }

    @Override
    public String toString() {
        return "tttt{" +
                "name='" + name + '\'' +
                '}';
    }
}
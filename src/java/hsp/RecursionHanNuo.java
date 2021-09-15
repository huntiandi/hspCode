package java.hsp;

/**
 * @ProjectName: work
 * @author: ZhangBiBo
 * @description: 汉诺塔
 * @data: 2021/9/14 23:31
 */
public class RecursionHanNuo {
    public static void main (String[] args){
    fff(3,'Q','W','E');
    }

    public static void fff(int num , char a,char b, char c){
        if (num ==1){
            System.out.println(a+"->"+c);
        }else {
            fff(num-1,a,c,b);//将n-1移到b
            System.out.println(a+"->"+c);//将n移到到c
            fff(num-1,b,a,c);//将b移动到c
        }
    }
}

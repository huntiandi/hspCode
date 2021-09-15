package hsp;

/**
 * @ProjectName: WorkSpace
 * @author: ZhangBiBo
 * @description: 递归方法-斐波那契数
 * @data: 2021/9/14 10:30
 */
public class Recursion {
    public static void main(String[] args) {
        int f = Rsion(6);
        System.out.println(f);
    }

    public static int Rsion(int n){
        //1 1 2 3 5 8 13
        if (n>=1){
            if (n == 1 || n == 2) {//当1和2时都为1
                return 1;
            } else {//当大于2时=n-1+n-2
                return Rsion(n - 1) + Rsion(n - 2);//等于很多的1加起来
            }
        }else {
            System.out.println("输入大于等于1的整数");
            return -1;
        }
    }


}

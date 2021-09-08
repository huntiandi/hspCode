package hsp;

/**
 * @ProjectName: work
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/9/7 22:32
 */
public class Test {
    public static void main (String[] args){
    int i = 1;
    //i = i++;
    int j = 0;
    double x = 5.0 / 9;
        System.out.println(i+"+"+j+"-"+x);
        for (int k = 1; k < 10; k++) {
            if (k<5) {
                for (int z = 1; z < 5 - k; z++) {
                    System.out.print(" ");
                }
                for (int l = 1; l <= 2 * k - 1; l++) {

                    if (l == 1 || l == 2 * k - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print("\n");
            }else {
                for (int z = 1; z < k-5; z++) {
                    System.out.print(" ");
                }
                for (int l = 1; l <=  k; l++) {


                        System.out.print("*");

                }
                System.out.print("\n");
            }
        }
    }

}

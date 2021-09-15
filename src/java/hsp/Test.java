package java.hsp;

/**
 * @ProjectName: work
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/9/7 22:32
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            if (i < 4) {
                for (int j = 0; j < 5 - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * i + 1; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            } else {
                for (int j = 0; j < i - 2; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 16 - (2 * i + 1); j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
    }

}

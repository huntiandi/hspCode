package java.hsp;

/**
 * @ProjectName: WorkSpace
 * @author: ZhangBiBo
 * @description:
 * @data: 2021/9/9 14:01
 */
public class Test2 {
    public static void main(String[] args) {
        double n = 0; double sum = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j <= i; j++) {
                sum+=j;
            }

        }

        System.out.println(sum);
    }
}

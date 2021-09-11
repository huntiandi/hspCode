package hsp;

/**
 * @ProjectName: WorkSpace
 * @author: ZhangBiBo
 * @description: 冒泡排序
 * @data: 2021/9/10 10:35
 */
public class Bubble {
    public static void main(String[] args) {
        int[] array = {11,1, 2, 9, 3, 8, 4,0};
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
    }
}

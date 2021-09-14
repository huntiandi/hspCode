package hsp;

/**
 * @ProjectName: work
 * @author: ZhangBiBo
 * @description: 递归之老鼠出迷宫
 * @data: 2021/9/14 22:49
 */
public class RecursionMouse {
    public static void main (String[] args){
    int[][] arrays = new int[6][7];
    arrays[3][1] = 1;
    arrays[3][2] = 1;
    arrays[2][2] = 1;//回溯现象
        for (int i = 0; i < arrays.length; i++) {
            arrays[i][0] = 1;
            arrays[i][6] = 1;
            for (int j = 0; j < arrays[i].length; j++) {
                arrays[0][j] = 1;
                arrays[5][j] = 1;
                System.out.print(arrays[i][j]+" ");
            }
            System.out.println("");
        }
        fff(arrays,1,1);
        System.out.println("==========");
        for (int i = 0; i <  arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j]+" ");
            }
            System.out.println("");
        }
    }

    /**
     *
     * @param map
     * @param i
     * @param j
     * @return
     * 0可以走1不可以走2走过3走过但是走不通，如果【4】【5】是2的话就结束
     */
    public static boolean fff (int[][] map,int i,int j){
        if (map[4][5]==2){
            return true;
        }else {
            if (map[i][j]==0) {//*只有为0的时候才能走
                map[i][j] = 2;//留下足迹，不然会一直走下去
                if (fff(map, i + 1, j)) {//先向下走一步
                    return true;
                } else if (fff(map, i, j + 1)) {//向右走
                    return true;
                } else if (fff(map, i - 1, j)) {//向上走一步
                    return true;
                } else if (fff(map, i, j - 1)) {//向左走一步
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            }else {//当为1，2，3时不能走；为3时回溯
                return false;
            }
        }
    }
}

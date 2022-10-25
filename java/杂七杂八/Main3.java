package 杂七杂八;

public class Main3 {
    private static int count = 0; //解法的计数器

    public static void main(String[] args) {
        //初始化棋盘，全部置为0
        short chess[][] = new short[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chess[i][j] = 0;
            }
        }

        putQueenAtRow(chess, 0);
        System.out.println("一共有" + count + "种解法");
    }
//------------------------------------------------------------------------------
    private static void putQueenAtRow(short[][] chess, int row) {

        //递归终止判断：如果row==8，则说明已经成功摆放了8个皇后 输出结果，终止递归

        if (row == 8) {//计有多少种解法
            count++;
            System.out.println("第 " + count + " 种解：");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(chess[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }

        //向这一行的每一个位置尝试排放皇后 然后检测状态，如果安全则继续执行递归函数摆放下一行皇后

        for (int i = 0; i < 8; i++) {
            // 摆放这一行的皇后，之前要清掉所有这一行摆放的记录，防止污染棋盘
            for (int j = 0; j < 8; j++) {
                chess[row][j] = 0;
            }
            chess[row][i] = 1;

            if (isSafety(chess, row, i)) {
                putQueenAtRow(chess, row + 1);
            }
        }
    }

    private static boolean isSafety(short[][] chess, int row, int col) {
        //判断中上、左上、右上是否安全
        int step = 1;
        while (row - step >= 0) {
            if (chess[row - step][col] == 1) //判断中上是否安全
                return false;
            if (col - step >= 0 && chess[row - step][col - step] == 1) //判断左上是否安全
                return false;
            if (col + step < 8 && chess[row - step][col + step] == 1) //判断右上是否安全
                return false;

            step++;
        }
        return true;
    }


}

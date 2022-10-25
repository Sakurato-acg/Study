package com.数据结构与算法DataStructures.递归;

//八皇后
public class 八皇后 {
    //定义一个二维的棋盘
    public static int[][] board = new int[8][8];
    public static int[] queen = new int[8];

    public static void main(String[] args) {
        setChess(0);

    }
    //定义判断是否可以放棋子的方法
    public static boolean isOk(int hang){
        boolean isFlag = true;
        for(int i = 0;i < hang; i ++){
            //问题来了，你怎么知道上一行的列，怎么由行得到他的列，又不是一维数组
            if (queen[i] == queen[hang]){
                isFlag =  false;
                break;
            }else if(Math.abs(hang - i) == Math.abs(queen[hang] - queen[i])){
                isFlag = false;
                break;
            }else{
                isFlag =  true;
            }
        }
        return isFlag;
    }
    //定义一个放棋子的效果，一旦放了一个其，那么对应期盼就会产生对应的变化
    public static void setChess(int hang){
        if (hang == 8){
            show(queen);
            return;
        }
        for(int i = 0;i < 8;i ++){
            queen[hang] = i;
            //设置当前行所对应的列数
            if(isOk(hang)){
                setChess(hang + 1);
            }
        }

    }
    //定义棋盘初始化的方法
    public static void reset(){
        for(int i = 0;i < 8;i ++){
            for(int j = 0;j < 8;j ++){
                board[i][j] = 0;
            }
        }
    }
    //定义输出棋盘的方法
    public static void show(int[] queen){
        reset();
        for(int i = 0;i < 8;i ++){
            board[i][queen[i]] = 1;
            for(int j = 0;j < 8;j ++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

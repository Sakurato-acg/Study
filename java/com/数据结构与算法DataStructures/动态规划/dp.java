package com.数据结构与算法DataStructures.动态规划;

import java.util.Arrays;

public class dp {
    public static void main(String[] args) {
        //4 8
        //2 3
        //3 4
        //4 5
        //5 6
        int[] weight = {2, 3, 4, 5};
        int[] value =  {3, 4, 5, 6};
        int maxsize = 8;
        int num = value.length;

        //v表示前i个物品中能够装入容量为j的max值
        int[][] v = new int[num + 1][maxsize + 1];

        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }

        Arrays.fill(v[0], 0);


//        for (int i = 1; i < v.length; i++) {
//            for (int j = 1; j < v[0].length; j++) {
//                if (weight[i - 1] > j) {
//                    v[i][j] = v[i - 1][j];
//                } else {
//                    v[i][j] = Math.max(v[i - 1][j], value[i - 1] + v[i - 1][j - weight[i - 1]]);
//                }
//                list(v);
//                System.out.println("——————————-");
//            }
//        }
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                for (int k = 0; k * weight[i-1] <= j; k++) {
                    v[i][j] = Math.max(v[i][j], v[i - 1][j - k * weight[i-1]] + k * value[i-1]);
                    list(v);
                    System.out.println("——————————-");
                }
            }
        }
        int index = v[0].length - 1;
        System.out.print(v[v.length - 1][v[0].length - 1] + "由价值");
        for (int i = v.length - 1; i >= 1; i--) {
            for (int j = index; j >= 1; j--) {

                if (v[i][j] == v[i - 1][j]) {
                    break;
                } else if (v[i][j] == value[i - 1] + v[i - 1][j - weight[i - 1]]) {
                    System.out.print(value[i - 1] + "+");
                    index = j - weight[i - 1];
                    break;
                }
            }

        }
        System.out.print("组成");
    }

    public static void list(int[][] v) {

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }
}
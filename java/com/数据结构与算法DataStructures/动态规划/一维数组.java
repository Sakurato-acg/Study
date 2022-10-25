package com.数据结构与算法DataStructures.动态规划;

import java.util.Arrays;

import static java.util.Arrays.*;

public class 一维数组 {
    public static void main(String[] args) {
//        4 8
//        2 3
//        3 4
//        4 5
//        5 6
        int[] weight = {2, 3, 4, 5};
        int[] value =  {3, 4, 5, 6};
        int maxsize = 8;
        int num = value.length;

        //v表示前i个物品中能够装入容量为j的max值
//        int[][] v = new int[num + 1][maxsize + 1];
        int []map=new int[maxsize+1];

        for (int i = 1; i < num+1; i++) {
            for (int j = 1; j < maxsize+1; j++) {
                for (int k = 0; k * weight[i-1] <= j; k++) {
                    map[j] = Math.max(map[j], map[j - k * weight[i-1]] + k * value[i-1]);
                    list(map);
                    System.out.println("——————————-");
                }
            }
        }
        //[0, 0, 3, 4, 6, 7, 9, 10, 12]
//        int index = maxsize;
////        System.out.print(v[v.length - 1][v[0].length - 1] + "由价值");
//        for (int i = maxsize; i >= 1; i--) {
//            for (int j = index; j >= 1; j--) {
//                if (v[j] == value[i - 1] + v[j - weight[i - 1]]) {
//                    System.out.print(value[i - 1] + "+");
//                    index = j - weight[i - 1];
//                    break;
//                }
//            }
//
//        }
//        System.out.print("组成");
    }

    public static void list(int[] v) {
        System.out.println(Arrays.toString(v));
    }
}

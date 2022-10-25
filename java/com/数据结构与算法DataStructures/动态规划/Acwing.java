package com.数据结构与算法DataStructures.动态规划;

import java.util.*;

public class Acwing {
    public static void main(String[] args) throws Exception {
        int maxn = 9;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();//分别表示物品种数和背包容积。
        int v[] = new int[maxn];    //体积
        int w[] = new int[maxn];    //价值
        int dp[][] = new int[maxn][maxn];
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        sc.close();
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k * v[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
                }
                list(dp);
            }
        }
        System.out.println(dp[n][m]);
    }
    public static void list(int [][]dp){
        for (int i = 0; i < dp.length ; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                System.out.print(dp[i][j]+"  ");
            }System.out.println();

        }System.out.println("___________");
    }
}

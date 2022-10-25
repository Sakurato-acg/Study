package com.数据结构与算法DataStructures.neko;

import java.util.Scanner;

public class 地推 {
    public static int[][] a;
    public static int n;
    public static int [][]rec;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        System.out.println(n);
        a = new int[n][n];
        rec=new int[6][6];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <= i; j++) {
                a[i][j] = kb.nextInt();
            }
        }
        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j <=i ; j++) {
                rec[i][j]=a[i][j]+max(rec[i+1][j],rec[i+1][j+1]);
            }
        }
        System.out.println(rec[0][0]);
    }
    public static int  max(int a, int b) {
        if (a < b) {
            System.out.println("-->"+b);
            return b;
        } else {
            System.out.println("-->"+a);
            return a;

        }
    }
}

package com.数据结构与算法DataStructures.neko;

import java.util.Scanner;
//https://www.bilibili.com/video/BV1wi4y1d77D?spm_id_from=333.788.header_right.history_list.click&vd_source=a97555db7a704882626ff6b3dff1617c
public class Neko第二集 {
    public static int[][] a;
    public static int n;
    public static int [][]rec;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        System.out.println(n);
        a = new int[n][n];
        rec=new int[n][n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <= i; j++) {
                a[i][j] = kb.nextInt();
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <=i ; j++) {
                rec[i][j]=-1;
            }
        }
        System.out.println(move(0, 0));
    }

    public static int move(int i, int j) {
        if (i == n-1) {
            return a[i][j];
        }
        if (rec[i][j]!=-1){
            return rec[i][j];
        }
        rec[i][j]=a[i][j]+max(move(i+1,j),move(i+1,j+1));
        return rec[i][j];
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

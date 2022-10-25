package com.数据结构与算法DataStructures.neko;

import java.util.Scanner;

public class 并查集 {
    public static int n;
    public static int m;
    public static int[] pre;

    public static int find (int x){
        if(x!=pre[x]){
            pre[x]=find(pre[x]);
        }
        return pre[x];
    }
    public static void union(int a,int b){
        int x=find(a);
        int y=find(b);
        pre[x]=y;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pre = new int[10];
        for (int i = 0; i < n; i++) {
            pre[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int k = kb.nextInt();
            int x = kb.nextInt();
            int y = kb.nextInt();
            if (k == 1) {
                union(x,y);
            }
            if (k == 2) {
                int x0 = find(x);
                int y0 = find(y);
                if (x0 == y0) {
                    System.out.println("Y");
                } else {
                    System.out.println("N");
                }
            }
        }
    }
}

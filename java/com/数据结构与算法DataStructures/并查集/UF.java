package com.数据结构与算法DataStructures.并查集;

import java.util.Scanner;

public class UF {
    public static void main(String[] args) {
        UF uf = new UF(5);
        Scanner kb = new Scanner(System.in);

        while (true) {

        }
    }

    //记录结点元素和该元素所在分组的标识
    private int[] eleAndGroup;

    //
    private int count;

    public UF(int n) {
        count = n;

        eleAndGroup = new int[n];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        return eleAndGroup[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }

        int i = find(p);

        int i1 = find(q);

        for (int i2 = 0; i2 < eleAndGroup.length; i2++) {
            if (eleAndGroup[i2] == i) {
                eleAndGroup[i2] = i1;
            }
        }
        count--;
    }
}

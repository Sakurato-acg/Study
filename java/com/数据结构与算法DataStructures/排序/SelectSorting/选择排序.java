package com.数据结构与算法DataStructures.排序.SelectSorting;

import java.util.Arrays;

public class 选择排序 {
    public static void main(String[] args) {
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(s(a)));
    }

    public static int[] s(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int index=i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] <a[index]) {
                    index=j;
                }
            }
            int temp=a[i];
            a[i] = a[index];
            a[index]=temp;
        }
        return a;
    }
}

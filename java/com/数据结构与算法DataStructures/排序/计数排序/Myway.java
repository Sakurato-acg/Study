package com.数据结构与算法DataStructures.排序.计数排序;

import java.util.Arrays;

public class Myway {
    public static void main(String[] args) {
        int[] a = {2, 7, 5, 5, 1, 0, 7, 1};
        System.out.println(Arrays.toString(sort(a)));
    }

    public static int[] sort(int[] a) {
        int max = a[0];
        for (int value : a)
        {
            if (value>max) max=value;
        }
        int []bucket=new int[max+1];
        for (int j : a) {
            bucket[j] ++;
        }

        int sortedIndex = 0;
        for (int j = 0; j <bucket.length; j++) {
            while (bucket[j] > 0) {
                a[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return a;
    }
}

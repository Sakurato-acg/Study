package com.数据结构与算法DataStructures.排序.归并排序;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] a = {8, 4, 5, 7, 1, 3, 6, 2};
//        int []a={3,5,4,7};
        int[] temp = new int[a.length];
        mergeSort(a, 0, a.length - 1, temp);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {

    }

    public static void mergeSort(int[] a, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
//            System.out.println(mid+"---");
            mergeSort(a, left, mid, temp);
            mergeSort(a, mid + 1, right, temp);
            merge(a, left, mid, right, temp);
        }
    }

    /**
     * @param a     原始数组
     * @param left  左边索引
     * @param mid   第二组索引
     * @param right 右边索引
     * @param temp  中转
     */
    public static void merge(int[] a, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        System.out.println("left="+left+" mid="+mid+" right="+right);
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[t] = a[i];
                t++;
                i++;
            } else if (a[i] > a[j]) {
                temp[t] = a[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {
            temp[t] = a[i];
            t++;
            i++;

        }
        while (j <= right) {
//            temp[t] = a[i];
            temp[t] = a[j];
            t++;
            j++;

        }
        t = 0;
        int index = left;
        while (index <= right) {
            a[index] = temp[t];
            t += 1;
            index += 1;
        }
    }
}

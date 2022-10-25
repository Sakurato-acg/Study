package com.数据结构与算法DataStructures.排序.快速排序;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int []a=new int[8];
        for (int i = 0; i < a.length; i++) {
            a[i]=a.length-i;
        }
        quick(a,0, a.length - 1);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
    }

    public static void quick(int[] a, int left, int right) {
        if (left<right){
            int mid=get_mid(a, left, right);
            quick(a,left,mid-1);
            quick(a,mid+1,right);
        }
    }
    public static int get_mid(int[] a, int left, int right) {
        int pivot = a[left];
        while (left < right) {
            while (a[right] >= pivot && left < right) {
                right--;
            }
            a[left] = a[right];
            while (a[left] <= pivot && left < right) {
                left++;
            }
            a[right] = a[left];

        }
        a[left]=pivot;
        return left;
    }
}

package com.数据结构与算法DataStructures.排序.希尔排序;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        //int[] a = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0, 6};
        int[] a = new int[80000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 8);
        }
        System.out.println(a.length);
        long s = System.currentTimeMillis();
        System.out.println(Arrays.toString(shell(a)));
        long e = System.currentTimeMillis();
        System.out.println(e - s + "ms");
    }

    //移位式
    public static int[] shell(int[] a) {
        if (a==null||a.length<=1){
            return a;
        }
        for (int gap=a.length/2;gap>0;gap/=2){
            for (int i = gap; i <a.length ; i++) {
                int val=a[i];
                int index=i-gap;
                while (index >= 0 && val < a[index]) {
                    a[index + gap] = a[index];
                    index=index-gap;
                }
                a[index + gap] = val;
            }
        }
        return a;
    }
    //交换式

    public static int[] insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        //希尔排序  升序
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {//每一次分成了几组
            //第一次分成了五组，每组2个数
            //第二次分成了两组，每组5个数
            for (int i = gap; i < arr.length; i++) {
                //i:代表即将插入的元素角标，作为每一组比较数据的最后一个元素角标
                //j:代表与i同一组的数组元素角标
                for (int j = i - gap; j >= 0; j = j - gap) {
//                    System.out.println(arr[j]+" a["+j+"]"+","+arr[j+gap]+" a["+(j+gap)+"]");
                    //  System.out.println(j+"_"+(j+gap));
                    //在此处-gap 为了避免下面数组角标越界
                    if (arr[j] > arr[j + gap]) {// j+gap 代表即将插入的元素所在的角标
                        //符合条件，插入元素（交换位置）
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                    // System.out.println(Arrays.toString(arr));
                }

            }
            //  System.out.println("-------------");
        }
        return arr;
    }
}

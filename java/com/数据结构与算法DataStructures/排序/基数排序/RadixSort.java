package com.数据结构与算法DataStructures.排序.基数排序;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {

//        int[] a = new int[80000];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = (int) (Math.random() * 8);
//        }
//        System.out.println(a.length);
//        long start = System.currentTimeMillis();
//        sort(a);
//        long end = System.currentTimeMillis();
//        System.out.println(end - start + "ms");
        int[] a = {31, 48, 12, 19, 10, 11};
//        sort(a);
//        System.out.println("---");
        sort(a);
    }

    public static void sort(int[] a) {
        int[][] tong = new int[10][a.length];
        int[] tt = new int[10];
        int max = 0;
        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);

        //求最大的位数
        for (int i = 0; i < a.length; i++) {
            int temp = 0;
            while (b[i] > 0) {
                b[i] = b[i] / 10;
                temp++;
            }
            if (temp > max) {
                max = temp;
            }

        }
        System.out.println(max);
        for (int k = 0, bs = 1; k < max; k++, bs = bs * 10) {

            for (int i = 0; i < a.length; i++) {
                int index = a[i] / bs % 10;
//                if (index < 0) {
//                    index = -index;
//                }
                tong[index][tt[index]] = a[i];
                tt[index]++;
            }
            int t = 0;
            for (int i = 0; i < tt.length; i++) {
                if (tt[i] > 0) {
                    for (int j = 0; j < tt[i]; j++) {
                        a[t] = tong[i][j];
                        tong[i][j] = 0;
                        t++;
                    }
                    tt[i] = 0;
                }
            }
            System.out.println(Arrays.toString(a));

        }

    }
//所有数加上最小数来消除负数
    public static void radixSort(int[] arr) {
        int max = arr[0];//假定最大数为第一个
        int min = 0;
        for (int m = 1; m < arr.length; m++) {
            if (arr[m] > max) {
                max = arr[m];
            }
            if (arr[m] < min) {
                min = arr[m];//找到负数最小值
            }
        }
        if (min < 0) {
            for (int mi = 0; mi < arr.length; mi++) {
                arr[mi] -= min;
                max -= min;
            }
        }
        System.out.println(Arrays.toString(arr) + "==");
        int maxLength = (max + "").length();//获取是几位数

        //定义一个二维数组，表示10个桶，每个桶就是一 个一维数组
        //说明
        //1.二维数组包含10个一维数组
        //2.为了防止在放入数的时候，数据溢出，则每个一维数组(桶),大小定为arr . length
        //3.名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];//以防所有数据个位数都是同一个数
        //为了记录每个桶中,实际存放了多少个数据,我们定义一一个-维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如: bucketElementCounts[0] ，记录的就是bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];
        for (int n = 0, g = 1; n < maxLength; n++, g *= 10) {
            for (int i = 0; i < arr.length; i++) {
                int digitOfElement = arr[i] / g % 10;// 求各位数的数值
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];// [个位数值][该数存放的第几个]
                bucketElementCounts[digitOfElement]++;
            }
            // 存放完毕后再取回原数组
            int index = 0;
            for (int j = 0; j < bucketElementCounts.length; j++) {
                if (bucketElementCounts[j] != 0) {
                    // 表示存储的有数据
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                bucketElementCounts[j] = 0;//为下一轮初始化
            }
            System.out.println(Arrays.toString(arr));

        }
        if (min < 0) {
            for (int mi = 0; mi < arr.length; mi++) {
                arr[mi] += min;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}



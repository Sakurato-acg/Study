package com.数据结构与算法DataStructures.排序.计数排序;

import java.util.Arrays;

public class CountingSort  {
    public static void main(String[] args) throws Exception {
        int[] a = new int[8];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 8);
        }
//        System.out.println(a.length);
        System.out.println(Arrays.toString(a));
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(sort(a)));

        long end = System.currentTimeMillis();
//        System.out.println(end - start);
    }
    public static  int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int maxValue = getMaxValue(arr);

        return countingSort(arr, maxValue);
    }

    private static int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

}
package com.数据结构与算法DataStructures.排序.BubbleSorting冒泡排序;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[8];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 8);
        }
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(f(a)));

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static String toString(int[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            s = s + a[i] + " ";
        }
        return s;
    }

    public static int[] f(int[] a) {
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag=false;
                }
                else {
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
            }
        return a;
        }

    }


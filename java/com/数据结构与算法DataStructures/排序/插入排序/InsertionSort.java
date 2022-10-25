package com.数据结构与算法DataStructures.排序.插入排序;

import java.util.Scanner;

public class InsertionSort{
    public static void main(String[] args) {
//        int[] a = new int[80000];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = (int) (Math.random() * 8);
//        }
//        System.out.println(a.length);
//        long start = System.currentTimeMillis();
//        System.out.println(Arrays.toString(tt(a)));
//
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
        Scanner kb=new Scanner(System.in);
        int []a=new int[8];
        for (int i = 0; i <a.length ; i++) {
            a[i]=kb.nextInt();
        }
        System.out.println(toString(a));
        tt(a);

    }
    public static String toString(int[] a){
        String s="";
        for (int i = 0; i < a.length; i++) {
            s=s+a[i]+" ";
        }
        return s;
    }
    public static int[] tt(int[] a) {
        int val;
        int index;
        for (int i = 1; i < a.length; i++) {
            val = a[i];
            index = i - 1;
            while (index >= 0 && val < a[index]) {
                a[index + 1] = a[index--];
            }
            a[index + 1] = val;
            System.out.println(toString(a));
        }
        return a;
    }
}

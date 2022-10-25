package com.数据结构与算法DataStructures.递归;

public class 汉罗塔 {
    public static void main(String[] args) {
        //doT(2,'A','B','C');
        System.out.println(doubleAdd(3));
        int n=99;
        for (int i = 1; i <=99; i++) {
            n=n*n;
            System.out.println(n);
        }

    }

    public static void doT(int num, char A, char B, char C) {
        if (num == 1) {
            System.out.println(A+"->"+C);
        }
        else {
            doT(num-1,A,C,B);
            System.out.println(A+"->"+C);
            doT(num-1,B,A,C);
        }
    }
    public static String  doubleAdd(int n){
        if (n==1||n==2){
            return String.valueOf(n);
        }else {
           return doubleAdd( n-1)+"+"+doubleAdd(n-2);
        }
    }
}

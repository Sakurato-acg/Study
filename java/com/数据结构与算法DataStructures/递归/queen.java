package com.数据结构与算法DataStructures.递归;

public class queen {
    static int max = 8;
    static int[] array = new int[max];
    static int num = 0;
    static int checkNum = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        cheekQueen(0);
        System.out.println(num);
        System.out.println(checkNum);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void cheekQueen(int n) {
        if (n == max) {
            num++;
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (check(n)) {
                cheekQueen(n + 1);
            }
        }
    }

    //n指第n个皇后
    public static boolean check(int n) {
        checkNum++;
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    public static void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

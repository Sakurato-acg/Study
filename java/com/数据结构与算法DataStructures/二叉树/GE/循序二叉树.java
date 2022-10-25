package com.数据结构与算法DataStructures.二叉树.GE;

import java.util.Arrays;

public class 循序二叉树 {
    public static void main(String[] args) {
        int []arr={0,1,2,3,4,5,6};
        System.out.println(Arrays.toString(arr));
        ArrTree arrTree = new ArrTree(arr);
        arrTree.mid(0);
    }
}

class ArrTree {
    private int[] arr;

    public ArrTree(int[] arr) {
        this.arr = arr;
    }
    public void pre(){
        this.pre(0);
    }
    public void pre(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("non");
            return;
        }
        System.out.print(arr[index]+" ");
        if (index * 2 + 1 < arr.length) {
            pre(2 * index + 1);
        }
        if (index * 2 + 2 < arr.length) {
            pre(2 * index + 2);
        }
    }
    public void mid(int index){
        if (arr == null || arr.length == 0) {
            System.out.println("non");
            return;
        }
        if (index * 2 + 1 < arr.length) {
            mid(2 * index + 1);
        }
        System.out.print(arr[index]+" ");

        if (index * 2 + 2 < arr.length) {
            mid(2 * index + 2);
        }
    }
}


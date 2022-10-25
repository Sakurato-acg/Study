package com.数据结构与算法DataStructures.排序.堆排序;

import java.util.Arrays;

public class MyWay {
    public static void main(String[] args) {
//        int[] tree = new int[7];
//        for (int i = 0; i < tree.length; i++) {
//            tree[i] = (int) (Math.random() * 10 + 1);
//        }
        int[] tree = {9, 1, 41, 5, 42, 4, 7};
        System.out.println(Arrays.toString(tree));
//        build_heap(tree, tree.length);
//        System.out.println(Arrays.toString(tree));
        heap_sort(tree,tree.length);
        System.out.println(Arrays.toString(tree));
    }

    public static void heap_sort(int[] tree, int n) {
        build_heap(tree,n);
        for (int i = n-1; i >0 ; i--) {
            swap(tree,i,0);
            heapify(tree,i,0);
        }

    }

    public static void build_heap(int[] tree, int n) {
        int last_node = n - 1;
        int parent = (last_node - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }

    @SuppressWarnings({"all"})
    public static void heapify(int[] tree, int len, int index) {
        if (index >= len) {
            return;
        }
        int c1 = 2 * index + 1;
        int c2 = 2 * index + 2;
        int max = index;
        if (c1 < len && tree[c1] < tree[max]) {
            max = c1;
        }
        if (c2 < len && tree[c2] < tree[max]) {
            max = c2;
        }
        if (max != index) {
            swap(tree, max, index);
            heapify(tree, len, max);
        }
    }

    public static void swap(int[] tree, int max, int index) {
        int temp = tree[index];
        tree[index] = tree[max];
        tree[max] = temp;
    }
}


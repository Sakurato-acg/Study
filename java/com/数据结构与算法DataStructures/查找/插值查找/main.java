package com.数据结构与算法DataStructures.查找.插值查找;

public class main {
    public static void main(String[] args) {
        int[] a = {1, 3, 7, 7, 7, 8, 8, 8};
        s(a, 0, a.length - 1, 9);
    }

    public static void s(int[] a, int left, int right, int key) {
        int mid = left + ((key - a[left]) / (a[right] - a[left])) * (right - left);
        if (left > right || key < a[0] || key > a[a.length - 1]) {
            System.out.println(-1);
        } else if (a[mid] < key) {
            s(a, mid + 1, right, key);
        } else if (a[mid] > key) {
            s(a, left, mid - 1, key);
        } else {
            System.out.println(mid + "--");
            int index = mid;
            if (index - 1 != -1) {
                while (a[index - 1] == a[index]) {
                    System.out.println(index - 1);
                    if (index - 1 == 0) {
                        break;
                    }
                    index--;
                }
            }
            System.out.println("--------------------");
            if (mid + 1 != a.length) {
                while (a[mid + 1] == a[mid]) {
                    System.out.println(mid + 1);
                    if (mid + 1 == a.length - 1) {
                        break;
                    }
                    mid++;
                }
            }
        }
    }

}

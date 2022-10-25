package com.数据结构与算法DataStructures.排序.快速排序;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        int[] a = new int[8];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = (int) (Math.random() * 8);
//        }
        int[] a = {4, 1, 1, 5, 6, 1, 0, 5};
        System.out.println(Arrays.toString(sort(a,0,a.length-1)));
        sort(a, 0, a.length - 1);
//        Solution solution = new
//                Solution();
//    System.out.println(Arrays.toString(solution.sortArray(a)));
    }

    public static int[] sort(int[] a, int left, int right) {
        int l = left;
        int r = right;
        int temp;
        int pivot = a[(left + right) / 2];
       // System.out.println("mid" + "=" + (left + right) / 2);
        //分组
        while (l < r) {
            while (a[l] < pivot) {
                l += 1;
            }
            while (a[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = a[r];
            a[r] = a[l];
            a[l] = temp;

            if (a[l] == pivot) {
                r -= 1;
            }
            if (a[r] == pivot) {
                l += 1;
            }
            if (left<r){
                sort(a,l,r);
            }
            if (right>l){
                sort(a,l,right);
            }
            //System.out.println(Arrays.toString(a));
        }
        //
        return a;
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


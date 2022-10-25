package com.数据结构与算法DataStructures.排序.堆排序;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = {9,8,7,6,15};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void heapSort(int[] array) {
        array = buildMaxHeap(array); //初始建堆，array[0]为第一趟值最大的元素
        for (int i = array.length - 1; i >= 1; i--) {
            int temp = array[0];  //将堆顶元素和堆底元素交换，即得到当前最大元素正确的排序位置
            array[0] = array[i];
            array[i] = temp;
            adjustHeap1(array, 0, i);  //整理，将剩余的元素整理成大顶堆
        }
    }

    //自下而上构建大顶堆：将array看成完全二叉树的顺序存储结构
    private static int[] buildMaxHeap(int[] array) {
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            adjustHeap1(array, i, array.length);
        }
        return array;

    }

    //自上而下调整大顶堆（非递归）
    private static void adjustHeap1(int[] array, int k, int length) {
        int temp = array[k]; //堆顶节点
        for (int i = 2 * k + 1; i <= length - 1; i = 2 * i + 1) {    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整

            if (i + 1 < length && array[i] < array[i + 1]) {  //如果左孩子小于右孩子
                i++;   //则取右孩子节点的下标
            }
            if (temp >= array[i]) {  //堆顶节点 >=左右孩子中较大者，调整结束
                break;
            } else {   //根节点 < 左右子女中关键字较大者
                array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        array[k] = temp;  //被堆顶结点的值放人最终位置

    }

    //自上而下调整大顶堆（递归）
    private static void adjustHeap2(int[] array, int k, int length) {
        int k1 = 2 * k + 1;
        if (k1 < length - 1 && array[k1] < array[k1 + 1]) {
            k1++;
        }
        if (k1 > length - 1 || array[k] >= array[k1]) {
            return;
        } else {
            int temp = array[k];  //将堆顶元素和左右子结点中较大节点交换
            array[k] = array[k1];
            array[k1] = temp;
            adjustHeap2(array, k1, length);
        }
    }


}
package com.数据结构与算法DataStructures.排序.堆排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeSort treeSort = new TreeSort();

        int[] arr = {9,1,41,5,42,4,7};
        heapSort(arr);
        treeSort.createTree(arr);
    }

    public static void heapSort(int[] arr) {
        int temp=0;
        for (int i = arr.length/2-1; i >=0 ; i--) {
            ad(arr,i, arr.length);
        }
        for (int j = arr.length-1; j>0 ; j--) {
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            ad(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void ad(int[] arr, int i, int len) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            if (arr[k] < arr[k + 1] && k + 1 < len) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;

    }
}

class TreeSort {
    public static List<Node> list = new ArrayList<Node>();      //用一个集合来存放每一个Node

    public void createTree(int[] array) {
        for (int i = 0; i < array.length; i++) {
            Node node = new Node(array[i]);    //创建结点，每一个结点的左结点和右结点为null
            list.add(node); // list中存着每一个结点
        }


        // 构建二叉树
        if (list.size() > 0) {
            for (int i = 0; i < array.length / 2 - 1; i++) {       // i表示的是根节点的索引，从0开始
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).left = list.get(2 * i + 1);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).right = list.get(2 * i + 2);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = array.length / 2 - 1;
            // 左结点
            list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (array.length % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }
        }
    }
}
    class Node {
        public int mun;
        public Node left;
        public Node right;

        public Node(int mun) {
            this.mun = mun;

        }

        @Override
        public String toString() {
            return "Node{" +
                    "mun=" + mun +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
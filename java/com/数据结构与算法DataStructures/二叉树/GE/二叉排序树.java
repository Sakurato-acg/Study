package com.数据结构与算法DataStructures.二叉树.GE;

import java.util.Scanner;

public class 二叉排序树 {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int len = kb.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }
        Tree1 head = new Tree1(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            insert(head, arr[i]);
        }
        list(head);


    }

    public static void list(Tree1 tree) {
        Tree1.midOder(tree);
        System.out.println();
        Tree1.search(tree);
    }

    //向 二 叉 树中插入子树
    public static void insert(Tree1 root, int data) {
        //二 叉排序树的右节点都比根节点大
        if (data >= root.val) {
            if (root.right == null)
                root.right = new Tree1(data);
            else
                insert(root.right, data);//递归插入子节点
        }
        //二 叉 排序树的左节点都比根节点小
        else {
            if (root.left == null)
                root.left = new Tree1(data);
            else
                insert(root.left, data);//递归插入子节点
        }
    }

}

class Tree1 {
    public int val;
    public Tree1 left;
    public Tree1 right;

    public Tree1(int val) {
        this.val = val;
    }

    public static void search(Tree1 tree) {
        System.out.print(tree+" ");
        //左
        if (tree.left != null) {
            search(tree.left);
        } else {
            System.out.print("# ");
        }
        //右
        if (tree.right != null) {
            search(tree.right);
        } else {
            System.out.print("# ");
        }
    }

    public static void midOder(Tree1 tree) {
        if (tree.left != null) {
            midOder(tree.left);
        }
        System.out.print(tree + " ");

        if (tree.right != null) {
            midOder(tree.right);
        }
    }

    @Override
    public String toString() {
        return val + "";
    }
}
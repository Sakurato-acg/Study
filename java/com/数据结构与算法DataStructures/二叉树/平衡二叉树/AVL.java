package com.数据结构与算法DataStructures.二叉树.平衡二叉树;

import java.util.Arrays;

public class AVL {
    public static void main(String[] args) {
//        int []arr={4,3,6,5,7,8};
//        int[] arr = {4, 3};
//        int []arr={10,12,8,9,7,6};
//        int[] arr = {10, 11, 7, 6, 8, 9};
        int[]arr={1,2,3,4,5,6,7,8,9};
        Node head = new Node(arr[0]);
        System.out.println("旋转前：");
        System.out.println(Arrays.toString(arr));
        Node node = null;
        for (int i = 1; i < arr.length; i++) {
            AVLTree.add(head, arr[i]);
            node= AVLTree.check(head);
        }

        AVLTree.list(node);
        System.out.println(node.left.height());
        System.out.println(node.right.height());
    }
}

class AVLTree {
    public static Node check(Node head) {
        int left = 0;
        int right = 0;
        if (head.left != null) {
            left = head.left.height();
        }
        if (head.right != null) {
            right = head.right.height();
        }
        System.out.print(left + "\t");
        System.out.println(right);
        Node node;
        if (right - left > 1) {

            if (head.right != null &&head.right.left!=null&&head.right.right!=null&& head.right.left.height() > head.right.right.height()) {
                AVLTree.RotateRight(head.right);
            }
            System.out.println("旋转后");
            node = AVLTree.RotateLeft(head);
        } else if (left - right > 1) {
            if (head.left != null &&head.left.left!=null&&head.left.right!=null&& head.left.right.height() > head.left.left.height()) {
                AVLTree.RotateLeft(head.left);
            }
            node = AVLTree.RotateRight(head);
            System.out.println("旋转后");
        } else {
            System.out.println("不需要旋转");
            node = head;
        }
        return node;
    }

    //中序遍历 按序输出
    public static void list(Node root) {
        if (root != null) {
            root.list(root);
        } else {
            System.out.println("kong");
        }
    }

    public static void add(Node head, int arr) {
        if (head == null) {
            return;
        }
        if (arr >= head.value) {
            if (head.right == null)
                head.right = new Node(arr);
            else
                add(head.right, arr);
        } else {
            if (head.left == null)
                head.left = new Node(arr);
            else
                add(head.left, arr);
        }
    }

//    public static int maxD(Node x) {
//        if (x == null) {
//            return 0;
//        }
//        int max = 0;
//        int maxL = 0;//左子树深度
//        int maxR = 0;
//        if (x.left != null) {
//            maxL = maxD(x.left);
//        }
//        if (x.right != null) {
//            maxR = maxD(x.right);
//        }
//        max = maxL > maxR ? maxL + 1 : maxR + 1;
//        return max;
//    }

    public static Node RotateLeft(Node head) {
        Node newNode = new Node(head.value);
        newNode.left = head.left;
        newNode.right = head.right.left;
        head.value = head.right.value;
        head.right = head.right.right;
        head.left = newNode;
        return head;
    }

    public static Node RotateRight(Node head) {
        Node newNode = new Node(head.value);
        newNode.right = head.right;
        newNode.left = head.left.right;
        head.value = head.left.value;
        head.left = head.left.left;
        head.right = newNode;
        return head;
    }

}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node[" +
                "value=" + value + ']';
    }

    public void list(Node root) {
        if (root.left != null) {
            list(root.left);
        }
        System.out.println(root);
        if (root.right != null) {
            list(root.right);
        }
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(),
                right == null ? 0 : right.height()) + 1;
    }

}

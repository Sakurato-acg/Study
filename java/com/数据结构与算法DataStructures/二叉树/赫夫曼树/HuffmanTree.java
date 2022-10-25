package com.数据结构与算法DataStructures.二叉树.赫夫曼树;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    static int index = 0;

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        //[1, 3, 6, 7, 8, 13, 29]
        //[4, 6, 7, 8, 13, 29]
        Node creat = creat(arr);
        pre(creat);

    }

    public static void pre(Node root) {
        if (root != null) {
            root.pre("");
        } else {
            System.out.println("空书");

        }
    }

    public static void set(ArrayList<Node> list) {
        Collections.sort(list);
        if (list.size() == 1) {
            return;
        }
        Node left = list.get(0);
        Node right = list.get(1);

        Node parent = new Node(left.val + right.val);
        parent.left = left;
        parent.right = right;

        list.remove(left);
        list.remove(right);

        list.add(parent);
        System.out.println("第" + (++index) + "次处理后" + list);
        set(list);
    }


    public static Node creat(int[] arr) {
        ArrayList<Node> list = new ArrayList<>();
        for (int val : arr) {
            list.add(new Node(val));
        }
        set(list);
        return list.get(0);
    }
}

class Node implements Comparable<Node> {
    public int val;
    public Node left;
    public Node right;
    public Node(int val) {
        this.val = val;
    }

    public void pre(String code) {
        boolean l=false;
        if (this.left != null) {
            l=true;
            code = code + "0";
            this.left.pre(code);
        }
        if (l){
            code=code.substring(0,code.length()-1);
        }
        if (this.right != null) {
            code = code + "1";
            this.right.pre(code);
        }
        if (this.left == null && this.right == null) {
            System.out.println(this);
            System.out.println(code);

        }
    }

    @Override
    public String toString() {
        return "Node{" + "val=" + val + '}';
    }


    @Override
    public int compareTo(Node o) {
        //从小到大 排序
        return this.val - o.val;
    }
}

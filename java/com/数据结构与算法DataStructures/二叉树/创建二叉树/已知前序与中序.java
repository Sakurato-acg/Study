package com.数据结构与算法DataStructures.二叉树.创建二叉树;

public class 已知前序与中序 {
    public static void main(String[] args) {
        String pre = "ABDEHICFKG";
        String mid = "DBHEIAFKCG";
        BitTree(pre.split(""), mid.split(""),0);
    }

    public static void BitTree(String[] pre, String[] mid,int count) {
        Node root = new Node(pre[count]);
        int index = 0;
        for (int i = 0; i < mid.length; i++) {
            if (pre[count].equals(mid[i])) {
                index = i;
                break;
            }
        }
        if (count!=0){
            root.left=new Node(mid[index-1]);
            root.right=new Node(mid[index+1]);
        }
        count++;
        BitTree(pre,mid,count);

    }
}

class Node {
    public String val;
    public Node left;
    public Node right;

    public Node(String s) {
        this.val = s;
    }

    @Override
    public String toString() {
        return val;
    }

    public void list() {
        System.out.println(this);
        if (this.left != null) {
            this.left.list();
        }
        if (this.right != null) {
            this.right.list();
        }
    }
}

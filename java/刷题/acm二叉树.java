package 刷题;

import java.util.Scanner;

public class acm二叉树 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        String[] split = str.split("");
        Tree tree = new Tree();
        Node node = tree.create(split);
        tree.head=node;
        int i = tree.preOder();
        tree.midOder();
        tree.posOder();
        System.out.println(i);
        System.out.println(Node.a);
    }
}

class Tree {
    public Node head;
    public int index;

    //前序
    public int preOder() {
        int count = 1;
        if (this.head != null) {
            count = this.head.preOder();
            System.out.println();
        }
        return count;
    }

    //中序
    public void midOder() {
        if (this.head != null) {
            this.head.midOder();
            System.out.println();
        }
    }

    //后序
    public void posOder() {
        if (this.head != null) {
            this.head.posOder();
            System.out.println();
        }
    }

    public Node create(String []arr){
        Node node;
        String str=arr[index];
        if (str.equals("#")){
            index++;
            return node=null;
        }else{
            node=new Node(arr[index++]);
            node.setLeft(create(arr));
            node.setRight(create(arr));
        }
        return node;
    }
}

class Node {
    private String val;
    private Node left;
    private Node right;
    public static int count = 1;
    public static int a = 0;

    public Node(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    //前序遍历
    public int preOder() {
        int check = 1;
        System.out.print(this);
        //左
        if (this.left != null) {
            count++;
            this.left.preOder();
        } else {
            check++;
        }
        //右
        if (this.right != null) {
            count++;
            this.right.preOder();
        } else {
            check++;
        }
        if (check==3){
            a++;
        }
        return count;
    }

    //中序遍历
    public void midOder() {
        if (this.left != null) {
            this.left.midOder();
        }
        System.out.print(this);

        if (this.right != null) {
            this.right.midOder();
        }
    }

    //后序遍历
    public void posOder() {
        if (this.left != null) {
            this.left.posOder();
        }
        if (this.right != null) {
            this.right.posOder();
        }
        System.out.print(this);
    }

    @Override
    public String toString() {
        return val;
    }
}
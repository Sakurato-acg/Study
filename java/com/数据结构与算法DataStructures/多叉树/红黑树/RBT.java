package com.数据结构与算法DataStructures.多叉树.红黑树;

import java.util.Objects;

public class RBT {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 6, 8, 5, 9};
        Tree tree = new Tree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(arr[i]);
        }
        Node head = tree.head;
        head.list(head);
        System.out.println("删除后——————————————————————————-");
        Node del = tree.del(head, 1);
        del.list(del);

    }
}

class Tree {
    private boolean RED = true;
    public boolean BLACK = false;
    private int num = 0;
    public Node head;

    //当前节点的左子与右子树都是RED时，让子树变黑，当前节点变红
    private void ReColor(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;

    }
    //左旋
    //当前节点E
    //右子节点S

    //左旋条件  当某个节点的左子树为黑色，右子树为红色时
    public Node RotateLeft(Node e) {
        Node s = e.right;//得到e的右子节点-> s

        e.right = s.left;

        s.left = e;

        s.color = e.color;
        e.color = RED;
        return s;
    }


    //右旋条件  当某个节点的左子树为红色，左子树的左子树也是红色时

    public Node RotateRight(Node h) {
        Node x = h.left;

        h.left = x.right;

        x.right = h;

        x.color = h.color;

        h.color = RED;

        return x;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    public void add(int value) {
        if (head == null) {
            head = new Node(value, null, null, BLACK);
        } else {
            head.color = BLACK;
            head = add(head, value);
        }

    }

    public Node add(Node node, int value) {
        if (node == null) {
            num++;
            return new Node(value, null, null, RED);
        }
        if (value < node.value) {
            node.left = add(node.left, value);
        }

        if (value > node.value) {
            node.right = add(node.right, value);
        }
        //左黑 右红  要左旋转
        if (isRed(node.right) && !isRed(node.left)) {
            node = RotateLeft(node);
        }


        //左红 左左红 右旋
        if (isRed(node.left) && isRed(node.left.left)) {
            node = RotateRight(node);
        }

        //左红 右红  重置颜色
        if (isRed(node.left) && isRed(node.right)) {
            ReColor(node);
        }

        return node;
    }

    public  Node del(Node head, int val) {
        if (head.left == null && head.right == null) {
            System.out.println("只有一个结点");
            return null;
        } else {
            return head.del(head, val);
        }
    }

}

class Node {
    public int value;
    public Node left;
    public Node right;
    public boolean color;

    public Node(int value, Node left, Node right, boolean color) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", color=" + color +
                '}';
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(),
                right == null ? 0 : right.height()) + 1;
    }

    public void list(Node head) {
        if (head.left == null && head.right == null) {
            if (head.color) {
                head.color = false;
            }
        }
        if (head.left != null) {
            list(head.left);
        }
        System.out.println(head);

        if (head.right != null) {
            list(head.right);
        }


    }


    public Node searchParent(Node head, int index) {
        if ((head.left != null && head.left.value == index)
                || (head.right != null && head.right.value == index)) {
            return head;
        } else {
            if (index < head.value && head.left != null) {
                return head.left.searchParent(head.left, index);
            } else if (index >= head.value && head.right != null) {
                return head.right.searchParent(head.right, index);
            } else {
                //没有父结点
                return null;
            }
        }
    }

    public Node checkTree;

    public Node search(Node head, int index) {
        if (index == head.value) {
            return head;
        } else if (index < head.value) {

            if (head.left == null) {
                checkTree = null;
            } else {
                checkTree = head.left.search(head.left, index);
            }
        } else {
            if (head.right == null) {
                checkTree = null;
            } else {
                checkTree = head.right.search(right, index);
            }
        }
        return checkTree;
    }

    public void ReColor(Node head,Node node){
        if (node==null){
            return;
        }
        if (node.color){
            node.color=false;
            return;
        }
        Node node1 = node.searchParent(head, node.value);
        ReColor(head,node1);

    }
    public Node del(Node head, int index) {

        Node search = search(head, index);

        if (search == null) {
            System.out.println("找不到要删除的结点");
            return null;
        }
        //一个二叉树只有一个结点的情况

        Node parent = searchParent(head, index);

        //情况一 删除叶子结点
        if (search.left==null && search.right==null){
            Node node = search.searchParent(head, search.value);
            if (node.left!=null && node.left==search){
                node.left=null;
            }
            else if (node.right!=null && node.right==search){
                node.right=null;
            }
            ReColor(head,node);

        }

            //
        // 情况二   删除有两个子树的结点
            if (search.left != null && search.right != null) {
                //要找到右子树的 最小结点
                Node min = findMin(search.right);
                Node node = min.searchParent(head, min.value);

                search.value=min.value;
                search.color=min.color;

                if (node.left==min){
                    node.left=null;
                }
            }
//        }
        return head;
    }


    public Node findMin(Node node) {
        if (node.left == null && node.right == null) {
            System.out.println("findMin");
            System.out.println(node);
            System.out.println("++++++++");
            return node;
        }

        return findMin(Objects.requireNonNullElseGet(node.left, () -> node.right));
    }

}

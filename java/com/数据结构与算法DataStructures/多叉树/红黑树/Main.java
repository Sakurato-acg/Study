package com.数据结构与算法DataStructures.多叉树.红黑树;

public class Main {
    public static void main(String[] args) {
        RedBlackTree<String, String> tree = new RedBlackTree<>();

        tree.put("1","1");
        tree.put("2","2");
        tree.put("3","3");

        String s1 = tree.get("1");
        System.out.println(s1);
        String s2 = tree.get("2");
        System.out.println(s2);
        String s3 = tree.get("3");
        System.out.println(s3);
    }
}

class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;
    private static final boolean RED = true;

    private static final boolean BLACK = true;

    private class Node {

        public Key key;//存储键
        public Value value;//存储值
        public Node left;//左节点
        public Node right;//右结点
        public boolean color;//父结点指向本结点的连接

        public Node(Key key, Value value,
                    Node left, Node right,
                    boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    ", color=" + color +
                    '}';
        }
    }

    public int size() {
        return N;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;

        h.right = x.left;

        x.left = h;

        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;

        h.left = x.right;

        x.right = h;

        x.color = h.color;

        h.color = RED;

        return x;
    }

    private void flipColor(Node h) {

        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;

    }

    public void put(Key key, Value val) {
        root=put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node root, Key key, Value val) {
        if (root == null) {
            N++;
            return new Node(key, val, null, null, RED);
        }

        int i = key.compareTo(root.key);
        if (i < 0) {
            root.left = put(root.left, key, val);
        } else if (i > 0) {
            root.right = put(root.right, key, val);
        } else {
            root.value = val;
        }

        if (isRed(root.right) && !isRed(root.left)) {
            root=rotateLeft(root);
        }

        if (isRed(root.left) && !isRed(root.left.left)){
            root=rotateRight(root);
        }
        if (isRed(root.left) && isRed(root.right)){
            flipColor(root);
        }

        return root;
    }

    public Value get(Key key){
        return get(root,key);
    }

    public Value get(Node x,Key key){
        if (x==null){
            return null;
        }

        int cmp=key.compareTo(x.key);

        if (cmp<0){
            return get(x.left,key);
        }
        else if (cmp>0){
            return  get(x.right,key);
        }
        else {
            return x.value;
        }
    }
}

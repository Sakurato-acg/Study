package com.hspedu.ch14.Collection_.List_.LinkedList_;

public class LinkedList_ {
    public static void main(String[] args) {
        Node node = new Node("LPLP");
        Node tom = new Node("Tom");
        //node--->tom
        node.next = tom;
        tom.pre = node;
        Node first = node;
        Node last = tom;
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first=first.next;
        }
    }
}

//简单双向链表
class Node {
    public Object item;
    public Node next;
    public Node pre;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}


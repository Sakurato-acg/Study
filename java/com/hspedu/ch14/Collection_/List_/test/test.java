package com.hspedu.ch14.Collection_.List_.test;

import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner (System.in);
        LinkList L = new LinkList();
        for (int x = sc.nextInt(); x != 0; x = sc.nextInt()) {
            L.insert(0, x);
        }
        L.display();
        int i=sc.nextInt();
        int x=sc.nextInt();
        L.insert(i,x);
        L.display();
        i=sc.nextInt();
        L.remove(i);
        L.display();
        i=sc.nextInt();
        Object o=L.get(i);
        System.out.println(o);
    }
}
class LinkList {
    Node head = new Node();

    public Object get(int i) throws Exception {
        Node p = head.getNext();
        int j = 0;
        while (p != null && j < i) {
            p = p.getNext();
            ++j;
        }
        if (j > i || p == null) {
            throw new Exception();
        }
        return p.getData();
    }

    public void insert(int i, Object x) throws Exception {
        Node p = head;
        int j = -1;
        while (p != null && j < i - 1) {
            p = p.getNext();
            ++j;
        }
        if (j > i - 1 || p == null) {
            throw new Exception("插入位置不合理");
        }
        Node s = new Node(x);
        s.setNext(p.getNext());
        p.setNext(s);
    }

    public void remove(int i) throws Exception {
        Node p = head;
        int j = -1;
        while (p.getNext() != null && j < i - 1) {
            p = p.getNext();
            ++j;
        }
        if (j > i - 1 || p.getNext() == null) {
            throw new Exception("删除位置不合理");
        }
        p.setNext(p.getNext().getNext());
    }

    public void display() {
        Node p = head.getNext();
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.getNext();
        }
        System.out.println();
    }
}

class Node {
    private Object data;
    private Node next;

    public Node() {
        this(null, null);
    }

    public Node(Object data) {
        this(data, null);
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}


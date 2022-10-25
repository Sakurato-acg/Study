package com.数据结构与算法DataStructures.Strack栈;

public class LinkedStack {
    public static void main(String[] args) {
        StackNode stackNode = new StackNode();
        stackNode.push("lpl");
        stackNode.push(1);
        stackNode.push(2);
        stackNode.list();
    }
}

class StackNode {
    private Node head = new Node("");
    private int top = 0;

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(Object value) {
        Node node = new Node(value);
        head.next = node;
        node.pre = head;
        head = node;
        head.next = null;
        top++;
    }

    public Node getHead() {
        return head;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("空");
        }

        head = head.pre;
        top--;
        return head.next.value;
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("空");
        }
        for (int i = top; i > 0; i--) {
            System.out.println(head);
            head = head.pre;
            top--;
        }
    }

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else  if(oper=='('||oper==')'){
            return -1;
        }else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/'||val == '('||val ==')';
    }

    public int cal(int num1, int num2, int oper) {
        int res = switch (oper) {
            case '+' -> num1 + num2;
            case '-' -> num2 - num1;
            case '*' -> num1 * num2;
            case '/' -> num2 / num1;
            default -> 0;
        };
        return res;
    }
}

class Node {
    public Object value;
    public Node next;
    public Node pre;

    public Node(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value ;}

}
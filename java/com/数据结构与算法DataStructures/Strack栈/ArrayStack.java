package com.数据结构与算法DataStructures.Strack栈;

public class ArrayStack {
    public static void main(String[] args) {
        Stack stack = new Stack(9);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.pop();

        stack.list();
        //java.util.Stack
    }
}

class Stack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("已满");
            return;
        }
        stack[++top] = value;
    }

    public int pop()  {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return stack[top--];
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("空");
        }
        for (int i = top; i >-1 ; i--) {
            System.out.printf("stack[%d]=%d\n" ,i,stack[i]);
        }
    }
}
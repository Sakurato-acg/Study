package com.数据结构与算法DataStructures.queue队列;

public class Test {
    public static void main(String[] args) throws Exception {
        TQ tq = new TQ(4);
        tq.addQ(9);
        tq.show();
        System.out.println("加一次-------------");
        tq.addQ(1);
        tq.show();
        System.out.println("加第二次-----------");
        tq.addQ(2);
        tq.getQ();
        tq.show();
        System.out.println("得到Font-------");
        tq.addQ(3);
        tq.show();
        System.out.println("++++");
        //
        tq.addQ(8);
        tq.show();
    }
}

//队列 类
class TQ {

    private int maxSize;
    private int front;//头
    private int rear;//尾
    private int[] arr;
    private int tag;

    public TQ(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        if (tag == 1) {
            return front == rear;
        } else {
            return (rear + 1 + maxSize) % maxSize == front;
        }
    }

    public boolean isEmpty() {
        if (tag == 1) {
            return false;
        } else {
            return front == rear;
        }
    }

    public void addQ(int n) {
        if (isFull()) {
            System.out.println("已满");
            return;
        }
        arr[rear] = n;
        if (rear == maxSize - 1) {
            tag = 1;
        }
        rear = (rear + 1) % maxSize;

    }

    public void getQ() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空");
        }

        System.out.println(arr[front]);
        front = (front + 1) % maxSize;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("kong");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

        }
    }

    public int size() {
        if (tag == 1) {
            return 1;
        } else {
            return (rear + maxSize - front) % maxSize;
        }
    }

    public int headQ() {
        if (isEmpty()) {
            System.out.println("空");
        }
        return arr[front];
    }
}
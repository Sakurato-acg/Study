package com.数据结构与算法DataStructures.queue队列;

public class CircleArrayQ {
    public static void main(String[] args) throws Exception {
        CircleQ circleQ = new CircleQ(4);
        circleQ.addQ(0);
        circleQ.addQ(1);
        circleQ.addQ(2);
        circleQ.getQ();
        circleQ.addQ(3);
        circleQ.show();
    }
}

//队列 类
class CircleQ {

    private int maxSize;
    private int front;//头 front=0
    private int rear;//尾下一个 rear=0
//    front指当前index
//    rear指当前后一个index
    private int[] arr;

    public CircleQ(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        get_info("");
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQ(int n) {
        if (isFull()) {
            System.out.println("已满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
        get_info("add之后");
    }

    public void getQ() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空");
        }

        System.out.println("get front:"+arr[front]);
        front = (front + 1) % maxSize;
        get_info("get之后");
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("kong");
        }
        for (int i = front; i <front+size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
        }
    }

    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    public int headQ() {
        if (isEmpty()) {
            System.out.println("空");
        }
        return arr[front ];
    }

    public void get_info(String str){
        System.out.println(str+"front:"+front);
        System.out.println(str+"rear:" + rear);
        System.out.println("----------------------");
    }
}
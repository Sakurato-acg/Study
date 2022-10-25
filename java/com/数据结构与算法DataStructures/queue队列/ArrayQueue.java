package com.数据结构与算法DataStructures.queue队列;



public class ArrayQueue {
    public static void main(String[] args) throws Exception {
        ArrayQ arrayQ = new ArrayQ(5);
        arrayQ.addQ(3);
        arrayQ.addQ(4);
        arrayQ.addQ(5);
        arrayQ.getQ();
        arrayQ.show();

    }
}
//队列 类
class ArrayQ {

    private int maxSize;
    private int front;//头 front=-1
    private int rear;//尾  rear=-1
//    front 指队列第一个的前一个index
//    rear指当前的index
    private final int[] arr;

    public ArrayQ(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    public boolean isFull(){
        return rear==maxSize-1;
    }
    public boolean isEmpty(){
        return front==rear;
    }
    public void addQ(int n){
        if (isFull()){
            System.out.println("已满");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    public void  getQ() throws Exception {
        if (isEmpty()){
            throw new Exception("队列为空");
        }
        front++;
        System.out.println(arr[front]);


    }
    public void show(){
        if (isEmpty()){
            System.out.println("kong");
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);

        }
    }
    public int headQ(){
        if (isEmpty()){
            System.out.println("空");
        }
        return arr[front+1];
    }
}
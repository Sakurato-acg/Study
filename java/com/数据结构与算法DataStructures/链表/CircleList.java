package com.数据结构与算法DataStructures.链表;

public class CircleList {
    public static void main(String[] args) {
        circle circle = new circle();
        circle.add(5);
        circle.list();
        long startTime = System.currentTimeMillis();
        circle.out(1, 2, 5);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println(endTime - startTime + "ms");
    }
}

class circle {
    private circleNode head = new circleNode(-1);


    public void add(int in) {
        if (in < 1) {
            System.out.println("no");
            return;
        }
        circleNode cur = null;
        for (int i = 1; i <= in; i++) {
            circleNode New = new circleNode(i);
            if (i == 1) {
                head = New;
                head.next = head;
                cur = head;
            } else {
                cur.next = New;
                New.next = head;
                cur = New;

            }
        }
    }

    public void list() {
        if (head == null) {
            System.out.println("空");
            return;
        }
        circleNode cur = head;
        while (true) {
            System.out.printf("编号%d \n", cur.no);
            cur = cur.next;
            if (cur == head) {
                break;
            }
        }

    }

    /**
     * @param k  开始
     * @param m  循环数
     * @param no 总人数 /** + enter
     */
    public void out(int k, int m, int no) {//从K开始数m个循环
        if (head == null || k < 1 || k > no) {
            System.out.println("有误");
            return;
        }
        circleNode helper = head;
        for (int i = 0; i < no + k - 2; i++) {
            helper = helper.next;
        }
        //上面是获取开始位置的前结点
        while (true) {
            if (helper.next == helper) {
                System.out.println("输出" + helper);
                break;
            }
            for (int i = 0; i < m - 1; i++) {
                helper = helper.next;
            }
            System.out.println("输出" + helper.next);
            helper.next = helper.next.next;
        }

        //我的法子
//        circleNode first = head;
//
//        int temp = 1;
//        while (true) {
//            if (temp == k) {
//                break;
//            }
//            temp++;
//            first = first.next;
//        }
//        temp = 1;
//        circleNode help=null;
//        while (true) {
//            if (temp == m) {
//                System.out.println(first.toString());
//                help.next=help.next.next;
//                first=first.next;
//                temp=1;
//            }
//            if (first==first.next){
//                System.out.println(first.toString());
//                break;
//            }
//            help=first;
//            first = first.next;
//            temp++;
//        }
    }
}

class circleNode {
    public int no;
    public circleNode next;


    public circleNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "circleNode{" +
                "no=" + no +
                '}';
    }
}

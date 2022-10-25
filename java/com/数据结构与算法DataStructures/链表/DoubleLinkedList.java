package com.数据结构与算法DataStructures.链表;

public class DoubleLinkedList {
    public static void main(String[] args) {
        DoubleL doubleL = new DoubleL();
        doubleL.add2(new DoubleNode(1, "1", "11"));
        doubleL.add2(new DoubleNode(4, "4", "44"));
        doubleL.add2(new DoubleNode(3, "3", "33"));
        doubleL.add2(new DoubleNode(2, "2", "22"));

        doubleL.list();
        System.out.println("_____________");
        doubleL.remove(3);
        doubleL.list();
    }
}

class DoubleL {
    private DoubleNode head = new DoubleNode(0, "", "");

    public void add(DoubleNode heroNode) {
        DoubleNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public DoubleNode getHead() {
        return head;
    }

    public void add2(DoubleNode heroNode) {
        DoubleNode temp = head;
        boolean flag = false;
        boolean flag1 = false;
        while (true) {
           if (temp.no>heroNode.no){
               break;
           }
           if (temp.next==null){
               flag=true;
               break;
           }
           if (temp.no==heroNode.no){
               flag1=true;
               break;
           }
           temp=temp.next;
        }
        if (flag1) {
            System.out.println("重复");
        }else if (flag){
            temp.next=heroNode;
            heroNode.pre=temp;
        }else {
           temp.pre.next=heroNode;
           heroNode.pre=temp.pre;
           heroNode.next=temp;
           temp.pre=heroNode;
        }
    }

    public void up(DoubleNode heroNode) {
        if (head.next == null) {
            System.out.println(1);
            return;
        }
        DoubleNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;

        } else {
            System.out.println("---");
        }
    }

    public void remove(int no) {
        if (head.next == null) {
            System.out.println(1);
            return;
        }
        DoubleNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("不存在");
        }

    }

    public void list() {
        if (head.next == null) {
            System.out.println("kong");
            return;
        }
        DoubleNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;

        }
    }
}

class DoubleNode {
    public int no;
    public String name;
    public String nickname;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
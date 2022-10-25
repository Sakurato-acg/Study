package com.数据结构与算法DataStructures.链表;

public class SingleLinkedList_ {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "李鹏雷", "lpl");
        HeroNode heroNode2 = new HeroNode(3, "雷", "lpl");
        HeroNode heroNode3 = new HeroNode(5, "dq雷", "lpl");



        HeroNode heroNode5 = new HeroNode(2, "ppp雷", "lpl");
        HeroNode heroNode6 = new HeroNode(4, "ppp雷", "lpl");
        HeroNode heroNode7 = new HeroNode(6, "ppp雷", "lpl");

        Single single1 = new Single();
        Single single2 = new Single();

        single1.add2(heroNode1);
        single1.add2(heroNode3);
        single1.add2(heroNode2);

        single1.list();

        single2.add2(heroNode5);
        single2.add2(heroNode6);
        single2.add2(heroNode7);

        //single1.list() ;
        //single1.up(heroNode4);
        //single1.list();
        //System.out.println("++++++++++");
        //single1.remove(heroNode2);
        //single1.list();
        HeroNode head1=single1.getHead();
        HeroNode head2=single2.getHead();

        Single NewSingle = new Single();

        NewSingle.getHead().next=head1.next;
        NewSingle.getHead().next=head2.next;
        NewSingle.list();

    }

  }

class Single {
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public HeroNode getHead() {
        return head;
    }

    public void add2(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("重复");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void up(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println(1);
            return;
        }
        HeroNode temp = head.next;
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

    public void remove(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println(1);
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next == heroNode) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("不存在");
        }

    }

    public void list() {
        if (head.next == null) {
            System.out.println("kong");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;

        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
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
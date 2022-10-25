package com.数据结构与算法DataStructures.哈希表;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(4);
        Emp[] sum = new Emp[6];
        sum[0] = new Emp(1, "NO1");
        sum[1] = new Emp(2, "NO2");
        sum[2] = new Emp(3, "NO3");
        sum[3] = new Emp(4, "NO4");
        sum[4] = new Emp(5, "NO5");
        sum[5] = new Emp(6, "NO6");
//        hashTab.add(sum[2]);
//        hashTab.add(sum[3]);
        hashTab.add(sum[5]);
        hashTab.add(sum[1]);
//        hashTab.add(sum[4]);
        hashTab.list();
        Scanner kb = new Scanner(System.in);
        System.out.println("根据ID找员工信息");
        int id = kb.nextInt();
        hashTab.find(id);
    }
}

class HashTab {
    private EmpLinkedList[] ListsArray;
    private int size;

    public void find(int id) {
        int i = hashFun(id);
        Emp emp = ListsArray[i].find(id);
        if (emp == null) {
            System.out.println("找不到");
        } else {
            System.out.println("找到了！\n员工id" + emp.id +
                    "的名字是" + emp.name);
        }
    }

    public HashTab(int size) {
        this.size = size;
        ListsArray = new EmpLinkedList[size];

        for (int i = 0; i < size; i++) {
            ListsArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int ArrayNum = hashFun(emp.id);
        ListsArray[ArrayNum].add(emp);
    }

    public int hashFun(int id) {
        return id % size;
    }

    public void list() {
        for (int i = 0; i < ListsArray.length; i++) {
            System.out.println("第" + (i) + "条链表");
            ListsArray[i].list(i);
        }
    }
}

class EmpLinkedList {
    private Emp head =new Emp(-1,"NO");

    public void add(Emp emp) {

        if (head == null) {
            head = emp;
            return;
        }
        Emp cur = head;

        while (cur.next != null) {
            if (emp.id == cur.next.id) {
                System.out.println("添加失败，已存在重复的雇员 id = " + emp.id);
                return;
            }
            // 按顺序添加（从小到大）
            if (emp.id < cur.next.id) {
                break;
            }
            // 后移
            cur = cur.next;
        }
//        cur.next = emp;
  //      System.out.println("");
        emp.next = cur.next;
        cur.next = emp;
        System.out.println("添加成功~");
    }

    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no) + "链表为空");
            return;
        }
        Emp cur = head.next;
        while (cur!= null) {
            System.out.printf("=> id=%d name=%s\t ", cur.id, cur.name);
            cur = cur.next;
        }
        System.out.println();
    }

    public Emp find(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp cur = head.next;
        while (true) {
            if (cur.id == id) {
//                System.out.println("员工id" + cur.id +
//                        "的名字是" + cur.name);
                break;
            }
            if (cur.next == null) {
                cur = null;
                break;
            }
            cur = cur.next;
        }
        return cur;
    }

    public void del(int id) {
        if (head == null) {
            System.out.println("KONG");
        }
        Emp cur = head;
        while (true) {
            if (cur.id == id) {
                System.out.println("删除员工" + cur.id +
                        "" + cur.name + " 的信息");
                cur.next = cur.next.next;
            }
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;
    public Emp pre;

    public Emp(int id, String name) {
        //super();
        this.id = id;
        this.name = name;
    }
}
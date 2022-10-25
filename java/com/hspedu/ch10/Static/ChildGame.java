package com.hspedu.ch10.Static;

/*
类变量、静态变量的快速入门
 */
public class ChildGame {
    public static void main(String[] args) {
        //int count =0;普通属性，普通成员变量，非静态变量
        //规范 类名。类变量名
        /*
        A a=new A()；
        A.name
        a.name
         */

        Child child1 = new Child("fsfs");
        child1.join();
        //child1.key++;
        //count++;
        child1.count++;
        Child child2 = new Child("fsfs");
        child2.join();
        child2.count++;
        //System.out.println("有"+Child.count);
        System.out.println("有" + child1.count);
        System.out.println("有" + child2.count);


    }

}

class Child {
    private String name;
    public int count = 0;
    public  static int key=5;

    //该变量最大的特点就是会被Child类的所有对象实例共享
    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(name + "加入");
    }
}

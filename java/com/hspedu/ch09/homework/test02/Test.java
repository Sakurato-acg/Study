package com.hspedu.ch09.homework.test02;

public class Test {
    public static void main(String[] args) {
        C c = new C();
       c.ss();
    }

}

class A {
    public A() {
        System.out.println("我是A类");
    }

    public A(String name) {
        System.out.println(name + "gesge");
    }
}

class B extends A {
    public B() {
        System.out.println("我是B类的无参");
    }

    public B(String name) {
        //调用A类无参
        System.out.println(name + "我是B类的有参");

    }
}

class C extends B {
    public C() {
        this("hello");
        System.out.println("我是C类的无参");
    }

    public C(String name) {
        super("hahaha");
        System.out.println("我是C类的有参");

    }

    public void ss() {
        System.out.println("wqdwq");

    }
}
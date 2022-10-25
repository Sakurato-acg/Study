package com.hspedu.ch10.Abstract;

public class Details {
    public static void main(String[] args) {
        //A a = new A();
        //无法实例化
    }
}
abstract class A{
//抽象类可以没有抽象方法
    public abstract void add();
}
 class B extends A{
    @Override
    public void add() {

    }
}

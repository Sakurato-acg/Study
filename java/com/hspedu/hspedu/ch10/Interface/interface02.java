package com.hspedu.ch10.Interface;

public class interface02 {
    public static void main(String[] args) {

    }
}

class Aa implements A {
    @Override
    public void hi() {

    }

}

interface A {
    //属性，方法
    public int n1 = 10;

    public void hi();//默认abstract

    default  public void ok() {
        System.out.println("hello");

    }
    public static void cry(){
        System.out.println("cry");
    }
}
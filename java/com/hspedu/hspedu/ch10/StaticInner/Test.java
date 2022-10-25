package com.hspedu.ch10.StaticInner;

public class Test {
    public static void main(String[] args) {
        //Outer.Inner.say();
       new Outer().f1();
       Outer.Inner inner=new Outer.Inner();
       inner.say();
    }
}

class Outer {
    private int n1 = 9;
    private static String name = "张三";

     public static class Inner {
        public  void say() {
            System.out.println(name);
        }
    }
    public void f1(){
        Inner inner = new Inner();
        inner.say();

    }
}
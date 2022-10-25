package com.hspedu.ch10.MemberInner;

public class Member1 {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.t1();
        Outer01.Innter01 innter01 = outer01.new Innter01();
        innter01.say();
        //Outer01.Innter01 innter011=new Outer01().new Innter01();

    }
}
class Outer01{
    private int n1=9;
    public String name="张三";
    class Innter01{
        public void say(){
            System.out.println("01的"+n1+name);
        }

    }
    public void t1(){
        Innter01 innter01 = new Innter01();
        innter01.say();

    }
}
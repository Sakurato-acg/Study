package com.hspedu.ch10.Abstract;

public class Test1 {
    public static void main(String[] args) {

    }
}

abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    /* public void eat(){//没意义的方法，不确定，父类=======抽象化
         System.out.println("NO");
     }*/
    //抽象类没实体；子类来用
    public abstract void eat();
}
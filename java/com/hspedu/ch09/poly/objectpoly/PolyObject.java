package com.hspedu.ch09.poly.objectpoly;

public class PolyObject {
    public static void main(String[] args) {
        //多态特点,Animal编译类型，Dog运行类型
        Animal animal=new Dog();
        animal.cry();
    }
}

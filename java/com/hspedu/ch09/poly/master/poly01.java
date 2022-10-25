package com.hspedu.ch09.poly.master;

public class poly01 {
    public static void main(String[] args) {
        Master fas = new Master("fas");
        Dog dog1 = new Dog("大黄");
        Bone bone1 = new Bone("asa");
        fas.feed(dog1,bone1);
       //实参可以是子类，形参可以是父类
    }

}

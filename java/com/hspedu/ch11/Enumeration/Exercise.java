package com.hspedu.ch11.Enumeration;

public class Exercise {
    public static void main(String[] args) {
        G b=G.BOY;
        G b1=G.BOY;
        System.out.println(b);
        System.out.println(b1==b);
    }
}
enum  G{
    BOY,GIRL;
}
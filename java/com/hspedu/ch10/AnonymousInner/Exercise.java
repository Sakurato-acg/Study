package com.hspedu.ch10.AnonymousInner;

public class Exercise {
    public static void main(String[] args) {
        f1(new AA(){
            @Override
            public void show() {
                System.out.println("lpl");
            }
        });
    }

    public static void f1(AA aa) {
        aa.show();
    }

}

interface AA {
    void show();
}
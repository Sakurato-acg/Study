package com.hspedu.ch10.InnerClass;

public class Inner01 {
    public static void main(String[] args) {

    }
}

class outer {//外部类
    private int n1 = 100;

    public void m1() {
        System.out.println("m1()");

    }

    {
        System.out.println("outer的代码块");
    }

    public outer(int n1) {
        this.n1 = n1;
    }

    class inner {//内部类


    }
}

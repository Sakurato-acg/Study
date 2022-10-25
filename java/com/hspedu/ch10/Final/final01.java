package com.hspedu.ch10.Final;

public class final01 {
    public static void main(String[] args) {
       /* E e = new E();
        e.RAT=0.09;*/

    }
}

final class A {

}

/*class B extends A{

}*/
class C {
    final public void hi() {
    }
}


class D extends C {
   /* @Override
    public void hi() {
        super.hi();
    }*/

}

class E {
    final public double TAX_RATE = 0.08;

}

class F {
    public void cry() {
        final double N = 0.08;
        /*N = 0.09;*/
    }
}
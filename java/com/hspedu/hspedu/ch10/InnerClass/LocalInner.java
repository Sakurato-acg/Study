package com.hspedu.ch10.InnerClass;

//演示局部内部类
public class LocalInner {
    public static void main(String[] args) {
       /* sdad sdad = new sdad();
        System.out.println(sdad.kl);
        //*/
        Outer01 outer01 = new Outer01();
        outer01.m1();

    }
}

class Outer01 {
    private int n1 = 100;

    private void m2() {
        System.out.println("m2的");

    }

    public void m1() {
        final class Inner_ {
            //不能添加访问修饰符，可以用final(不能被继承,特指class ，成员可以)
            //局部内部类
            //可以访问私有
            private int n1= 9090;

            public void f1() {
                System.out.println("n1=" + n1);
                //可以访问外部类的所有成员
                System.out.println(Outer01.this.n1);
                m2();
                f1();
            }

        }
        //外部类通过方法访问内部类
        Inner_ inner_ = new Inner_();
        inner_.f1();
    }
}

class mmm {
    public final int kl = 9;
}

class sdad extends mmm {

}
package com.hspedu.ch10.Final;

public class detail {
    public static void main(String[] args) {
   new EE().cc();
   System.out.println(Test.n1);
    }
}
class Test{
    public final static int n1=9;//不默认
    //public  static int n1=9;
    public int add(final int x){//默认
        return x+1;

    }    static {
        System.out.println("被执行");

    }
}
class CC {
    public final void cc() {
        System.out.println("ADAD");

    }
}
class EE extends CC{


}
class BB {
    private final static double TAX;

    static {
        TAX = 0.09;
    }

   /* public BB() {
        TAX=0.09;
    }*/
}

class AA {
    //构造器，代码块，定义。
    final public double TAX_RATE = 0.08;
    public final double TAX_RATE2;
    public final double TAX_RATE3;

    public AA() {
        TAX_RATE2 = 4.0;
    }

    {
        TAX_RATE3 = 3.0;
    }
}

package com.hspedu.ch10.CodeBlock;

public class details1 {
    public static void main(String[] args) {
        //new A();

        //new B();
        //System.out.println(C.i);//static
        C c1 = new C();//static 与普通同时调用
        System.out.println("============");
        C c = new C();//创建对象的时候调用普通代码块
        System.out.println("============");
        C.ASD();
        System.out.println("============");
        C c2 = new C();



    }
}
class  C{
    public static int i=1;
    static {
        System.out.println("CCCCCC");
    }//只能用一次


    {
        System.out.println("CcCcCcCcCcCc");
    }
    static void ASD (){
        System.out.println(i);
    }
}
class A{
    static {
        System.out.println("sdfs");
    }
}
class B extends A{
    static {
        System.out.println("lplplplpl");
    }
}
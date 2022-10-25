package com.hspedu.ch10.CodeBlock;

public class detail02 {
    public static void main(String[] args) {
        AA aa = new AA();
        //AA.getN1();


    }
}

class AA {
    //优先级1 static{}与static初始化同级
    //优先级2 （普通）{}与非静态变量初始化同级
    //优先级3  构造器
    private static int n1 = getN1();
    static {
        System.out.println("A的01");
    }



    public static int getN1() {
        System.out.println("yong");
        return 100;
    }
}

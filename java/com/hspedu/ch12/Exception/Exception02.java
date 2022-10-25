package com.hspedu.ch12.Exception;

public class Exception02 {

    public static void main(String[] args) {
        //NullPointException空指针异常
        String name=null;
        System.out.println(name.length());
        //ArithmeticException数字运算异常
        //ArrayIndexOutOfBoundsException
        int []arr={1,2,4};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
        //ClassCastException类型转换异常
        /*
        A b=new B();
        B b2=(B)b;
        C b2=(C) b
        */;
        //异常
        //NumberFormatException数字格式不正确异常
        String name1="dd";//1234可以
        //String转int
        int num=Integer.parseInt(name1);
        double n11=9.0;

    }
}
class A{}
class B extends A{}
class C extends A{}

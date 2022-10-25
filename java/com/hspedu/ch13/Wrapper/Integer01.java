package com.hspedu.ch13.Wrapper;

public class Integer01 {
    public static void main(String[] args) {
        //装箱 int------>Integer
        int n1 = 100;
        //Integer integer=new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);
        //拆箱
        // int i=integer.intValue();
        Integer integer2 = 100;
        System.out.println(n1 == integer2);//true

        //包装类转String
        Integer i1 = 100;
        //01
        String str1 = i1 + "";
        //02
        String str02 = i1.toString();
        //03
        String str03=String.valueOf(i1);

        //String 转包装类
        String str04="12345";
        Integer i2=Integer.parseInt(str04);
    }
}

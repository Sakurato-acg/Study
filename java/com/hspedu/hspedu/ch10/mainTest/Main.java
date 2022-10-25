package com.hspedu.ch10.mainTest;

public class Main {
    public static void main(String[] args) {
        //args怎么传入
        int []a={6,7,8,9,0};
        for (int i = 0; i <args.length ; i++) {
         System.out.println(a[i]+"  "+args[i]);
         }
        for (int j : a) {
            System.out.println(j);
        }
    }
}

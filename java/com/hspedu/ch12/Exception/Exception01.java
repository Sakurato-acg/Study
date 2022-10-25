package com.hspedu.ch12.Exception;

public class Exception01 {
    public static void main(String[] args)  {
        int num1=10;
        int num2=0;
        //int res=num1/num2;
        //Exception in thread "main"
        // java.lang.ArithmeticException:
        // / by zero
        //所以要抛出异常
        try {
            int res=num1/num2;
            //运行异常
        } catch (Exception e) {
           e.printStackTrace();
            //System.out.println(e.getMessage());
        }
        System.out.println("d");
    }
}

package com.hspedu.ch12.Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws01 {
    public static void main(String[] args) {

    }

    public static void f1() throws FileNotFoundException {
        //编译异常
       /* try {
            FileInputStream fis=new FileInputStream("d://aa.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        FileInputStream fis = new FileInputStream("d://aa.txt");
    }
}
class Father {
    public void method()throws RuntimeException{

    }
}
class Son extends Father {
    @Override
    public void method()throws NullPointerException{

    }
}



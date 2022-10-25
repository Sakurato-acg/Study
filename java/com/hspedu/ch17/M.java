package com.hspedu.ch17;

import com.hspedu.ch09.poly.master.Cat;

public class M {
    public static void main(String[] args) {
        //Thread
        cat cat = new cat();
        cat.start();
    }
}
class cat extends Thread implements Runnable {
    @Override
    public void run() {
        int i=1;
        while (true) {
            System.out.println(i);
            try {
                Thread.sleep(10);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



















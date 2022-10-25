package com.hspedu.ch17;

public class HomeWork {
    public static void main(String[] args) {
        MoneyA moneyA = new MoneyA();
        Thread thread1 = new Thread(moneyA);
        Thread thread2 = new Thread(moneyA);
        thread1.setName("No.1");
        thread2.setName("No.2");
        thread1.start();
        thread2.start();
    }
}

class MoneyA implements Runnable {
    public static int sal = 10000;
    public boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            synchronized (this) {
                if (sal < 1000) {
                    System.out.println("余额不足");
                    loop = false;
                    break;
                }
                sal = sal - 1000;
                System.out.println(Thread.currentThread().getName() + "取出1000，当前余额=" + sal);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

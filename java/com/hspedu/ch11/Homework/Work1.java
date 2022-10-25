package com.hspedu.ch11.Homework;

public class Work1 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock frock1 = new Frock();
        frock1.getSerialNumber();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();
        frock2.getSerialNumber();
        frock3.getSerialNumber();

    }
}

class Frock {
    private static int currentNum = 100000;
    private static int serialNumber;


    public Frock() {
        serialNumber = getNextNum();
    }

    public void getSerialNumber() {
        System.out.println(serialNumber);
    }

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }
}
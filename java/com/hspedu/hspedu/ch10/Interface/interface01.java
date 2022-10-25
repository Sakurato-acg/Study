package com.hspedu.ch10.Interface;

public class interface01 {
    public static void main(String[] args) {
        Camera camera=new Camera();
        Phone phone=new Phone();
        Computer computer = new Computer();
        computer.work(phone);
        computer.work(camera);


    }
}

interface Usb {
    public void start();

    public void stop();
}

class Phone implements Usb {//实现接口
    @Override
    public void start() {
        System.out.println("手机开始");
    }

    @Override
    public void stop() {
        System.out.println("手机结束");
    }
}

class Camera implements Usb {
    @Override
    public void start() {
        System.out.println("相机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("相机结束工作");
    }
}

class Computer {
    public void work(Usb usb) {
        usb.start();
        usb.stop();


    }
}
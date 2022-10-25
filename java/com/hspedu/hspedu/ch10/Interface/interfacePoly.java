package com.hspedu.ch10.Interface;

public class interfacePoly {
    public static void main(String[] args) {
        IF if01 = new Monster();
        if01=new Car();
        //Monster.a
        //IF anIf = new IF();
        AAA aaa=new BBB();
        System.out.println(aaa);
        aaa=new CCC();
        System.out.println(aaa);
        Usbinterface[]usbinterfaces=new Usbinterface[2];
        usbinterfaces[0]=new Phone_();
        usbinterfaces[1]=new Camera_();
        for (int i = 0; i < usbinterfaces.length ; i++) {
            usbinterfaces[i].work();
            if (usbinterfaces[i]instanceof Phone_){//判断运行类型
                ((Phone_) usbinterfaces[i]).call();
            }
        }
        //BBB{}
        //CCC{}
        //手机工作中
        //相机工作中
    }

}
interface Usbinterface{
    void work();
}
class Phone_ implements Usbinterface{
    public void call(){
        System.out.println("手机");
    }

    @Override
    public void work() {
        System.out.println("手机工作中");
    }
}
class Camera_ implements Usbinterface{
    @Override
    public void work() {
        System.out.println("相机工作中");
    }
}



interface IF {
int a=10;
}

class Monster implements IF {

}

class Car implements IF {

}
class AAA{}
class BBB extends AAA{
    @Override
    public String toString() {
        return "BBB{}";
    }
}
class CCC extends AAA{
    @Override
    public String toString() {
        return "CCC{}";
    }
}
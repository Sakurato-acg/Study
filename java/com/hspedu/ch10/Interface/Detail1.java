package com.hspedu.ch10.Interface;

public class Detail1 {
    public static void main(String[] args) {

    }
}
interface  IB{
    public static final int a=1;
    int m=1;
   public abstract void hi();
}
interface  IC{
   void say();
}
class Pig implements IB,IC{
    @Override
    public void hi() {

    }

    @Override
    public void say() {

    }
}
interface ID extends IB,IC{

}
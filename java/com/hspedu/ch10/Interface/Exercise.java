package com.hspedu.ch10.Interface;

public class Exercise {
    public static void main(String[] args) {

    }
}
interface Z{
     int x=0;
}
class C{
    int x=1;
}
class V extends C implements Z{
    public void pX(){
        System.out.println(super.x+""+Z.x);

    }

    public static void main(String[] args)   {
        new V().pX();
    }
    /*public void pX(){
        System.out.println(x);

    }

    public static void main(String[] args) {
        new V().pX;
    }*/
}
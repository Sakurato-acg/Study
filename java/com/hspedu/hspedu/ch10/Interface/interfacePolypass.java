package com.hspedu.ch10.Interface;

public class interfacePolypass {
    public static void main(String[] args) {
        IG ig=new Teacher();

        //多态传递现象
        IH ih=new Teacher();
    }
}
interface IH{
public abstract void W();
public static final int a=1;
}
interface IG extends IH{

}
class Teacher implements IG{
    @Override
    public void W() {

    }
}
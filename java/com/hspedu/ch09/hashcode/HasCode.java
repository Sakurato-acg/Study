package com.hspedu.ch09.hashcode;

public class HasCode {
    public static void main(String[] args) {
        AA aa1=new AA();
        AA aa2=new AA();
        AA aa3=aa1;
        System.out.println(aa1.hashCode()+"\n"+aa2.hashCode()+"\n"+aa3.hashCode());

    }
}
class AA{

}
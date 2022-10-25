package com.hspedu.ch14.Collection_.List_;


import java.util.List;
import java.util.Vector;

public class Vector_ {
    public static void main(String[] args) {
        List list=new Vector();
        list.add("adad");
        list.add("lplpl");
        list.add("lppppp");
        //每次扩容X2
        System.out.println(list);

    }
}

package com.hspedu.ch14.Collection_.List_;

import java.util.ArrayList;
import java.util.List;
//List接口的方法
public class ListAll {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("marry");
        list.add("marry");
        System.out.println(list);
        //数组
        System.out.println(list.get(2));
        //看截屏
    }
}

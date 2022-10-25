package com.hspedu.ch20;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stream_ {
    public static void main(String[] args) {
        Integer []t={0,3,4,1};

        Stream.iterate(0,a->a+2).limit(10)
                .forEach(System.out::println);
       // https://blog.csdn.net/PorkBird/article/details/11372770
        List <String> list=new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);
    }
}

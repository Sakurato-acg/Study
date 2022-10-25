package com.hspedu.ch14.Collection_.Set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("all")
public class HashSet_ {
    public static void main(String[] args) {
        //set接口
        Set set = new HashSet();
        set.add("Alice");
        set.add("joun");
        set.add("joun");
        set.add("Mike");
        set.add("Mike");
        set.add(null);
        System.out.println(set);
        //[null, Mike, Alice, joun]
        //遍历
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(o);
        }

        System.out.println("=============");

        for (Object o : set) {
            System.out.println(o);
        }

    }
}

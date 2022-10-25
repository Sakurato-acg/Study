package com.hspedu.ch14.Collection_.List_;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArrayList_ {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("jackmmmm");//add
        System.out.println(list);
        list.remove(0);//remove 删除
        System.out.println(list);

        list.add("lpl");
        list.add(1);
        System.out.println(list.contains(1));
        //contains 查找元素
        System.out.println(list.size());
        //size 获取元素个数
        System.out.println(list.isEmpty());
        //isEmpty()     判断是否为空
        //clear         清空
        //addAll        添加多个元素
        //containsAll   查找多个元素是否都存在
        //remove        删除多个元素
        System.out.println("-------");
        Te.dada();
    }

    static  class Te {
        public static void dada() {
            Collection col = new ArrayList();
            col.add(5);
            col.add(4);
            col.add(3);
            col.add(2);
            Iterator iterator = col.iterator();
            //itit快捷键
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}

package com.hspedu.ch14.Map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class    HashMap_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, new Yg("xiao", 999, 1));
        map.put(2, new Yg("yuanjiyao", 10000, 2));
        map.put(3, new Yg("lpl", 34232, 3));
        //keySet
        Set set1 = map.keySet();
        for (Object k : set1
        ) {
            Yg o = (Yg) map.get(k);
            if (o.salary>=10000){
                System.out.println(k+"-"+o.name);
            }
        }
        System.out.println("---------------------------------------------------------");
        //迭代器
        Set set2=map.entrySet();
        Iterator iterator=set2.iterator();
        while (iterator.hasNext()){
            Map.Entry entry=(Map.Entry) iterator.next();
            Yg yg= (Yg) entry.getValue();
            if (yg.salary>=10000){
                System.out.println(entry.getKey()+"--"+yg.name);
            }
        }

    }
}

class Yg {
    public String name;
    public int salary;
    public int id;

    public Yg(String name, int salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Yg{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}
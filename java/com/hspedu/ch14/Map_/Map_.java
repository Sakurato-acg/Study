package com.hspedu.ch14.Map_;

import java.util.HashMap;
import java.util.Map;

public class Map_ {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("B",2);
        map.put("A",2);
        System.out.println(map.get("A"));
        System.out.println(map);
    }
}

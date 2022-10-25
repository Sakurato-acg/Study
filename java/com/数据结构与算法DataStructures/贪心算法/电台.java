package com.数据结构与算法DataStructures.贪心算法;

import java.util.*;

public class 电台 {
    public static void main(String[] args) {
        String s="北京，上海，天津，广州，深圳，成都，杭州，大连";
        String[] split = s.split("，");
        HashMap<String, HashSet<String>> hashMap = new HashMap<>();

        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add(split[0]);
        hashSet1.add(split[1]);
        hashSet1.add(split[2]);


        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add(split[3]);
        hashSet2.add(split[0]);
        hashSet2.add(split[4]);


        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add(split[5]);
        hashSet3.add(split[1]);
        hashSet3.add(split[6]);

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add(split[1]);
        hashSet4.add(split[2]);

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add(split[6]);
        hashSet5.add(split[7]);

        hashMap.put("k1",hashSet1);
        hashMap.put("k2",hashSet2);
        hashMap.put("k3",hashSet3);
        hashMap.put("k4",hashSet4);
        hashMap.put("k5",hashSet5);

        HashSet<String> allAreas = new HashSet<>();
        Collections.addAll(allAreas, split);

        ArrayList<String> selects = new ArrayList<>();

        HashSet<String> tempSet = new HashSet<>();

        while (allAreas.size()!=0){
            for (String key :hashMap.keySet()){
                 HashSet<String> areas =hashMap.get(key);

                 tempSet.addAll(areas);

                 tempSet.retainAll(allAreas);
            }
        }
    }
}

package com.hspedu.ch14;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList x=new ArrayList();
        for (int i = 0; i < n; i++) {
            x.add(kb.next());
        }
        x.sort(Comparator.reverseOrder());
        System.out.println(x.get(0));
    }
}

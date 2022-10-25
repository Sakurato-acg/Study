package 必看;

import java.util.*;

public class TeeSet_ {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int all = kb.nextInt();

        //TreeSet 去重+排序
        TreeSet treeSet = new TreeSet();
        for (int i = 0; i < all; i++) {
            treeSet.add(kb.nextInt());
        }
        System.out.println(treeSet.size());
        Object[] pp = treeSet.toArray();
        for (int i = 0; i < pp.length; i++) {
            System.out.print(pp[i] + " ");
        }
    }
}



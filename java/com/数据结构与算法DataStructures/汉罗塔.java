package com.数据结构与算法DataStructures;

public class 汉罗塔 {
    public static void main(String[] args) {
        int nDisks = 2;
        doTowers(nDisks, 'A', 'B', 'C');
    }

    //topN=3  from=A  inter=B  to=C
//topN=1  from=A  inter=C  to=B
    public static void doTowers(int topN, char A, char B, char C) {
        if (topN == 1) {
            System.out.println("Disk 1 from " + A + " to " + C);
        } else {
            doTowers(topN - 1, A, C, B);
            System.out.println("Disk " + topN + " from " + A + " to " + C);
            doTowers(topN - 1, B, A, C);
        }
    }
}

package com.数据结构与算法DataStructures.Kruskal;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
//木子喵neko
public class kr {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int nums = data.length;
        MGraph mGraph = new MGraph(data, nums);
        mGraph.add('A', 'B', 12);
        mGraph.add('B', 'C', 10);
        mGraph.add('C', 'D', 3);
        mGraph.add('D', 'E', 4);
        mGraph.add('E', 'G', 8);
        mGraph.add('A', 'G', 14);

        mGraph.add('A', 'F', 16);
        mGraph.add('B', 'F', 7);
        mGraph.add('C', 'F', 6);
        mGraph.add('E', 'F', 2);
        mGraph.add('F', 'G', 9);


        mGraph.add('C', 'E', 5);

        mGraph.sort();
        mGraph.listOut();
        mGraph.creat();
    }
}

class EData {
    char start; // 边的起点
    char end;   // 边的终点
    int weight; // 边的权重

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

class MGraph {
    public ArrayList<EData> list;
    int n;//顶点的数量
    int m = 0;//边的数量
    char[] data;
    int[] pre;

    public MGraph(char[] data, int size) {
        this.data = data;
        n = size;
        list = new ArrayList<>();
    }

    public void add(char start, char end, int weight) {
        list.add(new EData(start, end, weight));
        m++;
    }
    public void listOut(){
        for (int i = 0; i <list.size(); i++) {
            System.out.println(list.get(i));

        }
    }
    public void sort() {
        Collections.sort(list, new Comparator<EData>() {
            @Override
            public int compare(EData o1, EData o2) {
                return o1.weight - o2.weight;
            }
        });

    }

    int ans = 0;//记录边权之和

    int t = 0;//记录加入了多少边

    public int find(int x) {
        if (x != pre[x]) {
            pre[x] = find(pre[x]);
        }
        return pre[x];
    }

    public void creat() {
        pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[data[i] - 65] = i;
        }

        for (int i = 0; i < m; i++) {

            int a = find(list.get(i).start - 65);
            int b = find(list.get(i).end - 65);
            if (a != b) {
                pre[a] = b;
                ans += list.get(i).weight;
                t++;
                System.out.println(Arrays.toString(pre));
                System.out.println(list.get(i).start+" -> "+list.get(i).end);

                if (t == n - 1) {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(pre));
        if (t != n - 1) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}


//class MGraph_ {
//    public ArrayList<EData> edgeList;
//    int size;
//    int count = 0;
//
//    public MGraph_(int size) {
//        this.size = size;
//        edgeList = new ArrayList<>(size);
//    }
//
//    public void add(char start, char end, int weight) {
//        EData eData = new EData(start, end, weight);
//        edgeList.add(eData);
//        count++;
//    }
//
//    public void sort() {
//        Collections.sort(edgeList, new Comparator<EData>() {
//            @Override
//            public int compare(EData o1, EData o2) {
//                return o1.weight - o2.weight;
//            }
//        });
//
//    }
//
//}
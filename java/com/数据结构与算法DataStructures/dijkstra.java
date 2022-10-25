package com.数据结构与算法DataStructures;


import java.util.Arrays;

//无负权边的单源最短路
public class dijkstra {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Graph graph = new Graph(6);
        graph.add(1, 2, 1);
        graph.add(1, 3, 12);
        graph.add(2, 3, 9);
        graph.add(2, 4, 3);
        graph.add(3, 5, 5);
        graph.add(4, 3, 4);
        graph.add(4, 5, 13);
        graph.add(4, 6, 15);
        graph.add(5, 6, 4);


        graph.list();
        graph.dijkstra_();
        long end = System.currentTimeMillis();
        System.out.println(" 用 时 : "+(end-start));
    }
}
//配图 C:\Users\lpl\Desktop\java 学习\数据结构\dijkstra.png
/*
  1.领接表
  2.定源点，创建dis数组(存储路径长度)，dis_数组(是否访问过)
  3.找领接的边，找最小
 */
class Graph {
    public static int[] dis;
    public static boolean[] dis_;
    public        int[][] map;
    public        int size;
    public final  int INF = 1000;

    public Graph ( int size ) {
        this.size = size;
        map = new int [ size + 1 ] [ size + 1 ];
    }

    public void add ( int start , int end , int weight ) {
        map [ start ] [ end ] = weight;
    }

    public void list () {
        for ( int i = 1; i < map.length; i++ ) {
            for ( int j = 1; j < map[0].length; j++ ) {
                if ( map [ i ] [ j ] == 0) {
                    continue;
                }
                System.out.println(i + "-->" + j + "==" + map[i][j]);
            }
        }
    }

    //永远按照1是起始点
// https://www.bilibili.com/video/BV1aA4y197FP
    public void dijkstra_() {
        dis = new int[size + 1];
        dis_ = new boolean[size + 1];
        int sum=0;

        for (int i = 1, k = 1; k < map.length; ) {
            dis_[i] = true;

            for (int j = 1; j < map[0].length; j++) {
                if (dis_[j]) {
                    continue;
                }
                if (map[i][j] == 0) {
                    dis[j] = INF;
                } else if (dis[i] + map[i][j] < dis[j]) {
                    dis[j] = dis[i] + map[i][j];
                } else {
                    dis[j] = map[i][j];
                }

            }
            k++;
            System.out.print(i + "-->");
            i = findmin(i);
            System.out.println(i);
        }
        for (int i = 1; i < dis.length; i++) {
            System.out.print(dis[i]+" ");
        }
        System.out.println();
    }

    public int findmin(int index) {
        int re = 0;
        int min = 10000;
        for (int i = 1; i < dis.length; i++) {
            if (!dis_[i] && dis[i] < min) {
                min = dis[i];
                re = i;
            }
        }
        return re;
    }
}

package com.数据结构与算法DataStructures;

import java.util.Arrays;

//https://www.bilibili.com/video/BV1gb41137u4/?
//https://www.bilibili.com/video/BV1Sp4y1S7pd/?
public class bellman_ford {

    public long[] dis;       //用于存放第0个顶点到其它顶点之间的最短距离

    //内部类，表示图的一条加权边
    public static class Edge {
        public int from;   //边的起点
        public int to;   //边的终点
        public double cost;  //边的权值

        public Edge(int a, int b, double value) {
            this.from = a;
            this.to = b;
            this.cost = value;
        }
    }

    public static double[] bellmanFord(Edge[] edges, int v, int start) {
        double[] dis = new double[v];
        Arrays.fill(dis, Double.POSITIVE_INFINITY);
        dis[start] = 0;

        for (int i = 0; i < v - 1; i++) {
            for (Edge edge : edges) {
                if (dis[edge.from] + edge.cost < dis[edge.to]) {
                    dis[edge.to] = dis[edge.from] + edge.cost;
                }
            }
        }

        for (int i = 0; i < v - 1; i++) {
            for (Edge edge : edges) {
                if (dis[edge.from] + edge.cost < dis[edge.to]){
                    dis[edge.to]=Double.NEGATIVE_INFINITY;
                }
            }
        }
        return  dis;
    }



    public static void main(String[] args) {
        int E=10,V=9,start=0;
        Edge[]edge=new Edge[E];
        edge[0]=new Edge(0,1,1);
        edge[1]=new Edge(1,2,1);
        edge[2]=new Edge(2,4,1);
        edge[3]=new Edge(4,3,-3);
        edge[4]=new Edge(3,2,1);
        edge[5]=new Edge(1,5,4);
        edge[6]=new Edge(1,6,4);
        edge[7]=new Edge(5,6,5);
        edge[8]=new Edge(6,7,4);
        edge[9]=new Edge(5,7,3);

        double []a=bellmanFord(edge,V,start);
        for (int i = 0; i <V ; i++) {
            System.out.printf("The cost to get from node to %d to %d id %.2f\n ",start,i,a[i]);
        }

    }

}

package com.数据结构与算法DataStructures.图;

import java.util.ArrayList;
import java.util.Arrays;

public class HSP图的基本 {
    public static void main(String[] args) {
        int n=5;//结点的个数
        String []VertexValue ={"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String value: VertexValue)  {
            graph.insert(value);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.show();
    }
}
class Graph  {
    public ArrayList<String> vertexList;//存储顶点集合
    public int [][]edges;//存储对应的领接矩阵
    public int numOfEdges;//表示边的条目

    public Graph(int n){
        edges = new int[n][n];
        vertexList =new ArrayList<String>(n);
        numOfEdges=0;
    }

    public void insert(String vertex){
        vertexList.add(vertex);
    }
    //添加边
    public void insertEdge(int v1,int v2,int weight){

        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }

    public int get_vertexList(){
        return vertexList.size();
    }

    public int get_numOfEdges(){
        return numOfEdges;
    }

    public String getValue(int i){
        return vertexList.get(i);
    }
    public int getWeight(int v1,int v2){
        return  edges[v1][v2];
    }
    //显示矩阵
    public void show(){
        for (int [] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }
}

package com.数据结构与算法DataStructures.图;

//深度优先遍历

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    public static void main(String[] args) {

    }
}
class Graph1{
    public ArrayList<String> vertexList;//存储顶点集合
    public int [][]edges;//存储对应的领接矩阵
    public int numOfEdges;//表示边的条目
    public boolean[] isVisited;
    public Graph1(int n){
        edges = new int[n][n];
        vertexList =new ArrayList<String>(n);
        numOfEdges=0;
        isVisited=new boolean[n];
    }

    public int getFirst(int index){
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }
    public void dfs (int i){
        System.out.println(getValue(i));
        isVisited[i]=true;

        int w=getFirst(i);
        while (w!=-1){
            if (!isVisited[w]){
                dfs(w);
            }
            w=getNext(i,w);
        }
    }
    public int getNext(int start,int end){
        for (int j = end+1; j < vertexList.size(); j++) {
            if (edges[start][j]>0){
                return j;
            }
        }
        return -1;
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

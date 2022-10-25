package com.数据结构与算法DataStructures.Prim;

import com.hspedu.ch17.M;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int nums = data.length;
        MGraph mGraph = new MGraph(nums);
        mGraph.insertEdge('A', 'B', 5);
        mGraph.insertEdge('A', 'G', 2);
        mGraph.insertEdge('A', 'C', 7);

        mGraph.insertEdge('B', 'A', 5);
        mGraph.insertEdge('B', 'G', 3);
        mGraph.insertEdge('B', 'D', 9);

        mGraph.insertEdge('C', 'A', 7);
        mGraph.insertEdge('C', 'E', 8);

        mGraph.insertEdge('D', 'B', 9);
        mGraph.insertEdge('D', 'F', 4);

        mGraph.insertEdge('E', 'C', 8);
        mGraph.insertEdge('E', 'G', 4);
        mGraph.insertEdge('E', 'F', 5);

        mGraph.insertEdge('F', 'E', 5);
        mGraph.insertEdge('F', 'G', 6);
        mGraph.insertEdge('F', 'D', 4);

        mGraph.insertEdge('G', 'A', 2);
        mGraph.insertEdge('G', 'B', 3);
        mGraph.insertEdge('G', 'E', 4);
        mGraph.insertEdge('G', 'F', 6);

        mGraph.show();

        MinTree minTree = new MinTree(data.length, data, mGraph.edges);
        minTree.show();

        System.out.println("-----------");
        minTree.creat();
    }
}


class MinTree {
    char[] data;
    int nums;
    int[][] edges;

    boolean[] select;
    int[] minDisk;
    char[] parent;

    public MinTree(int nums, char[] data, int[][] edges) {
        this.nums = nums;
        this.data = data;
        this.edges = edges;
    }

    public void show() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
    //-------------------------------------------------------//


    public void setBasic() {
        select = new boolean[nums];
        minDisk = new int[nums];
        parent = new char[nums];
        Arrays.fill(select, false);
        Arrays.fill(minDisk, 10000);
        for (int i = 0; i < parent.length; i++) {
            parent[i] = (char) -1;
        }

    }

    ArrayList arrayList = new ArrayList();

    public void creat() {
        setBasic();
        for (int i = 0,count=0;;) {
            select[i] = true;
            minDisk[i] = 99999;
            int min = 10000;
            int indexMin = 0;
            for (int j = 0; j < edges[i].length; j++) {
                if (edges[i][j] != 10000 && edges[i][j] != 0 && !select[j]) {

                    if (edges[i][j] < minDisk[j]) {
                        minDisk[j] = edges[i][j];
                        parent[j] = data[i];
                    }

                }

            }

            for (int j = 0; j <minDisk.length ; j++) {
                if (minDisk[j]<min){
                    indexMin=j;
                    min=minDisk[j];
                }
            }

            if (select[indexMin] == false && parent[indexMin]==data[i]) {
                System.out.println(data[i] + "->" + data[indexMin]);
                i = indexMin;
                count++;

                System.out.println(indexMin);

                System.out.println(Arrays.toString(select));
                System.out.println(Arrays.toString(minDisk));
                System.out.println(Arrays.toString(parent));
                System.out.println();
                if (count==nums-1){
                    break;
                }
            }
            else
            {
                i=parent[indexMin]-65;
            }
        }
    }

}

//class MGraph {
//    public ArrayList<Character> vertexList;//存储顶点集合
//    public ArrayList<ArrayList<Integer>> edges;//存储对应的领接矩阵
//    public int numOfEdges;//表示边的条目
//
//    public MGraph(int n) {
//        edges=new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            edges.add(new ArrayList<>(n));
//        }
//        for (int i = 0; i <n ; i++) {
//            edges.get(i)
//        }
//        vertexList = new ArrayList<>(n);
//        numOfEdges = 0;
//    }
//
//    public void insert(char vertex) {
//        vertexList.add(vertex);
//    }
//
//    //添加边
//    public void insertEdge(char v1, char v2, int weight) {
//
//        ArrayList<Integer> arrayList = edges.get(v1 - 65);
//        arrayList.add(v2-65,weight);
//        edges.get(v2-65).add(v1-65,weight);
//        numOfEdges++;
//    }
//
//    public int get_vertexList() {
//        return vertexList.size();
//    }
//
//    public int get_numOfEdges() {
//        return numOfEdges;
//    }
//
//    public char getValue(int i) {
//        return vertexList.get(i);
//    }
//
//    public int  getWeight(int v1, int v2) {
//        return edges.get(v1-65).get(v2-65);
//    }
//
//    public ArrayList <ArrayList<Integer>> getEdges(){
//        return edges;
//    }
//    //显示矩阵
//    public void show() {
//        for (ArrayList<Integer> edge : edges) {
//            for (Integer integer : edge) {
//                System.out.println(integer + "  ");
//            }
//        }
//    }
//}

class MGraph {
    public ArrayList<Character> vertexList;//存储顶点集合
    public int[][] edges;//存储对应的领接矩阵
    public int numOfEdges;//表示边的条目

    public MGraph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length; j++) {
                edges[i][j] = 10000;
            }
        }
    }

    public void insert(char vertex) {
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(char v1, char v2, int weight) {

        edges[v1 - 65][v2 - 65] = weight;
        edges[v2 - 65][v1 - 65] = weight;
        numOfEdges++;
    }

    public int get_vertexList() {
        return vertexList.size();
    }

    public int get_numOfEdges() {
        return numOfEdges;
    }

    public char getValue(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public int[][] getEdges() {
        return edges;
    }

    //显示矩阵
    public void show() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
}

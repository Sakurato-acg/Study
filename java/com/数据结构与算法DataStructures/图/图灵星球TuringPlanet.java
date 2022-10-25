package com.数据结构与算法DataStructures.图;

import java.util.*;

public class 图灵星球TuringPlanet {
    public static void main(String[] args) {
//        int n = 7;//结点的个数--
        int n=7;
        String[] VertexValue = {
                "A",//0
                "B",//1
                "C",//2
                "D",//3
                "E",//4
                "F",//5
                "G",//6
                "H"//7
        };
        ListGraph listGraph = new ListGraph(n);

        listGraph.addEdge(0, 1);//A B

        listGraph.addEdge(1, 2);//B C
        listGraph.addEdge(1, 4);//B F
        listGraph.addEdge(1, 5);//B E

        listGraph.addEdge(2, 4);//C E
        listGraph.addEdge(3, 2);//D C
        listGraph.addEdge(4, 1);//E B
        listGraph.addEdge(4, 3);//E D
        listGraph.addEdge(5, 6);//F G
//
//        listGraph.addEdge(0,1);
//        listGraph.addEdge(0,2);
//        listGraph.addEdge(1,3);
//        listGraph.addEdge(1,4);
//        listGraph.addEdge(2,5);
//        listGraph.addEdge(2,6);

        ArrayList<ArrayList<Integer>> lists = listGraph.lists();
//        System.out.println("A=0  " + "B=1 " + "C=2 " + "D=3 " + "E=4 " + "F=5 " + "G=6\n");
        for (int i = 0; i < lists.size(); i++) {
            System.out.print(VertexValue[i] + "  ");
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
//        Graph graph = new Graph(n);
//        for (String value: VertexValue)  {
//            graph.insert(value);
//        }
//        graph.insertEdge(0,1,1);
//        graph.insertEdge(0,2,1);
//        graph.insertEdge(1,2,1);
//        graph.insertEdge(1,3,1);
//        graph.insertEdge(1,4,1);
//
//        graph.show();
        Graph_Traversal graph_traversal = new Graph_Traversal(listGraph, VertexValue);
        System.out.println("DFS");
        graph_traversal.DFS();
        System.out.println("\nBFS");
        graph_traversal.BFS();
    }
}

class Graph_Traversal {

    ListGraph graph;
    boolean[] visited;

    public ArrayList<String> arrayList;


    public Graph_Traversal(ListGraph listGraph, String[] set) {
        this.graph = listGraph;
        visited = new boolean[listGraph.graphs.size()];
        this.arrayList = new ArrayList<>();
        Collections.addAll(arrayList, set);
    }

    public void DFS() {
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]) {
                DFS(i);
            }
        }
        Arrays.fill(visited, false);
    }

    public void DFS(int v) {
        if (visited[v]) {
            return;
        }

        System.out.print(arrayList.get(v) + "->");
        visited[v] = true;


        ListIterator<Integer> neighbors = graph.graphs.get(v).listIterator();
        while (neighbors.hasNext()) {

            int nextNode = neighbors.next();

            if (!visited[nextNode]) {
                DFS(nextNode);
            }
        }
    }

    //---------------

    public void BFS_Traversal(int v) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[v] = true;
        queue.offerLast(v);

        while (queue.size() != 0) {
            Integer cur = queue.pollFirst();
//            System.out.println("输出"+arrayList.get(cur) + "->");
            System.out.print(arrayList.get(cur)+"->");

            Iterator<Integer> neighbors = graph.graphs.get(cur).iterator();
//            System.out.println("获取"+arrayList.get(cur)+"的关系链");
            while (neighbors.hasNext()) {
                int nextNode = neighbors.next();
//                System.out.println("下一个"+arrayList.get(nextNode));
                if (!visited[nextNode]) {
                    queue.offerLast(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }

    public void BFS() {
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]) {
                BFS_Traversal(i);
            }
        }
    }
}

class ListGraph {
    public ArrayList<ArrayList<Integer>> graphs;

    public ListGraph(int v) {
        graphs = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graphs.add(new ArrayList<>());
        }
    }

    public ArrayList<ArrayList<Integer>> lists() {
        return graphs;
    }

    public void addEdge(int start, int end) {
        graphs.get(start).add(end);
    }

    public void removeEdge(int start, int end) {
        graphs.get(start).remove(end);

    }
}

class Queue implements java.util.Queue<Integer> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean offer(Integer integer) {
        return false;
    }

    @Override
    public Integer remove() {
        return null;
    }

    @Override
    public Integer poll() {
        return null;
    }

    @Override
    public Integer element() {
        return null;
    }

    @Override
    public Integer peek() {
        return null;
    }
}
package 杂七杂八;

import java.util.*;

public class MYtest {
    public static void main(String[] args) {
        Scanner kb=new Scanner (System.in);
        String type=kb.next();

        int m=kb.nextInt();
        int n=kb.nextInt();
        String []VertexValue=new String[m];
        for (int i = 0; i < VertexValue.length; i++) {
            VertexValue[i]=kb.next();
        }
        ListGraph listGraph = new ListGraph(m);

        for (int i = 0; i <n ; i++) {
            String s1=kb.next();
            String s2=kb.next();
            listGraph.addEdge(s1,s2);
        }
        for (int i = 0; i < listGraph.graphs.size(); i++) {
            listGraph.graphs.get(i).sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int t1 = Integer.parseInt(o1.substring(1));
                    int t2 = Integer.parseInt(o2.substring(1));
                    return t2 - t1;
                }
            });

        }

        Graph_Traversal graph_traversal = new Graph_Traversal(listGraph, VertexValue);
        graph_traversal.BFS();
        System.out.println();
        graph_traversal.DFS();
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

        System.out.print(arrayList.get(v) + " ");
        visited[v] = true;


        ListIterator<String> neighbors = graph.graphs.get(v).listIterator();
        while (neighbors.hasNext()) {

            String n = neighbors.next();
            int nextNode= Integer.parseInt(n.substring(1));
            if (!visited[nextNode]) {
                DFS(nextNode);
            }
        }
    }

    //---------------
    //添加从后面，取出从前面
    public void BFS_Traversal(int v) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[v] = true;
        queue.offerFirst(v);

        while (queue.size() != 0) {
            Integer cur = queue.pollFirst();
            System.out.print(arrayList.get(cur)+" ");

            Iterator<String> neighbors = graph.graphs.get(cur).iterator();
            while (neighbors.hasNext()) {
                String n=neighbors.next();
                int nextNode = Integer.parseInt(n.substring(1));
                if (!visited[nextNode]) {
                    if (queue.size()!=0&&!visited[queue.getFirst()] )
                    {
                    queue.offerFirst(nextNode);
                    }
                    else {
                        queue.offerLast(nextNode);
                    }
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
        Arrays.fill(visited, false);
    }
}

class ListGraph {
    public ArrayList<ArrayList<String>> graphs;

    public ListGraph(int v) {
        graphs = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graphs.add(new ArrayList<>());
        }
    }

    public ArrayList<ArrayList<String>> lists() {
        return graphs;
    }

    public void addEdge(String start, String end) {
        int s= Integer.parseInt(start.substring(1));
        graphs.get(s).add(end);
    }


}

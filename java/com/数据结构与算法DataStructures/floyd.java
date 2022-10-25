package com.数据结构与算法DataStructures;
//https://blog.csdn.net/qq_26020387/article/details/105901599
import java.util.Arrays;

public class floyd {
    public static void main(String[] args) {
        //创建顶点
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final short N = Short.MAX_VALUE;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};

        //创建graph对象
        Graph_ graph = new Graph_(matrix,vertex);
        //调用弗洛伊德算法
        graph.floyd();
        graph.show();
    }
}

/**
 * 创建图
 */
class Graph_ {
    /**
     * 存放顶点的数组
     */
    private char[] vertes;
    /**
     * 保存从各个顶点触发到其他顶点的距离,最后的结果也是保留在该数组
     */
    private int[][] dis;
    /**
     * 保存到达目标顶点的前驱顶点
     */
    private int[][] pre;

    public Graph_(int[][] matrix, char[] vertex) {
        this.vertes = vertex;
        this.dis = matrix;
        this.pre = new int[vertex.length][vertex.length];
        //对pre数组初始化,注意存放的是前驱顶点的下标
        for (int i = 0; i < vertex.length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    /**
     * 显示pre数组和dis数组
     */
    public void show() {
        //为了显示便于阅读
        for (int k = 0; k < dis.length; k++) {
            //先将pre数组输出到一行
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertes[pre[k][i]] + " ");
            }
            System.out.println();
            System.out.println("+++++++++++++");
            //输出dis数组的一行数据
            for (int i = 0; i < dis.length; i++) {
                System.out.println(" <" + vertes[k] + "," + vertes[i] + "> => " + dis[k][i]);
            }
            System.out.println("=======================");
        }
    }

    /**
     * 弗洛伊德算法
     */
    public void floyd() {
        //保存距离
        int len;
        //对中间顶点遍历
        for (int mid = 0; mid < dis.length; mid++) {
            //从i顶点开始出发
            for (int from = 0; from < dis.length; from++) {
                //到达j顶点
                for (int to = 0; to < dis.length; to++) {
                    //求出从i顶点出发经过k到达j的距离
                    len = dis[from][mid] + dis[mid][to];
                    //若len小于dis[i][j],则进行更新
                    if (len < dis[from][to]) {
                        //更新距离
                        dis[from][to] = len;
                        //更新前驱顶点
                        pre[from][to] = pre[mid][to];
                    }
                }
            }
        }
    }
}

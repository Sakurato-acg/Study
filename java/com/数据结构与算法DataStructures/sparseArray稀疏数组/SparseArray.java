package com.数据结构与算法DataStructures.sparseArray稀疏数组;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class SparseArray {
    public static void main(String[] args) throws IOException {
        //创建原始数组
        //0表示没棋子，1表示黑子，2表示蓝色
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 2;
        //输出原始的数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
        //转稀疏数组
        //1。获取有效数组

        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {

            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组  结构 行 列 值
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[1].length;
        sparseArr[0][2] = sum;

        //存放非 0 值4
        int hang = 1;
        for (int i = 0; i < chessArr1.length; i++) {

            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[hang][0] = i;
                    sparseArr[hang][1] = j;
                    sparseArr[hang][2] = chessArr1[i][j];
                    hang++;
                }
            }
        }


        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        System.out.println("---------------------------------------");

        //将稀疏数组保存到磁盘上，如map.data
        File file = new File("src\\map.data");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
        for(int i = 0; i < sparseArr.length; i++) {
            outputStreamWriter.write(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2] + ",");
        }
        outputStreamWriter.close();//关闭输出流
        fileOutputStream.close();//关闭输出流


        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

        StringBuffer sb = new StringBuffer();
        while(inputStreamReader.ready()) {
            sb.append((char)inputStreamReader.read());
        }
        inputStreamReader.close();//关闭输入流
        fileInputStream.close();//关闭输入流


        String[] sb1 = sb.toString().split(",");
        //System.out.printf("从磁盘读取的字符串为：\n%s\n", ss);//格式化输出
        //恢复稀疏数组
        int sum1 = 0;
        int[][] sparseArr1 = new int[sb1.length/3][3];
        sparseArr1[0][0] = Integer.parseInt(sb1[0]);
        sparseArr1[0][1] = Integer.parseInt(sb1[1]);
        sparseArr1[0][2] = Integer.parseInt(sb1[2]);
        for(int i = 3; i < sb1.length; i += 3) {
            sum1++;
            sparseArr1[sum1][0] = Integer.parseInt(sb1[i]);
            sparseArr1[sum1][1] = Integer.parseInt(sb1[i+1]);
            sparseArr1[sum1][2] = Integer.parseInt(sb1[i+2]);
        }
//        System.out.println("还原后的稀疏数组为：");
//        for(int i = 0; i < sparseArr1.length; i++) {
//            System.out.printf("%d\t%d\t%d\n", sparseArr1[i][0], sparseArr1[i][1], sparseArr1[i][2]);
//        }


        System.out.println("+++++++++++++");

        int[][] chess =new int[sparseArr1[0][0]][sparseArr1[0][1]];
        for (int i = 1; i <sparseArr.length ; i++) {
            chess[sparseArr1[i][0]][sparseArr1[i][1]]=sparseArr1[i][2];
        }
        for (int[] row : chess) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}

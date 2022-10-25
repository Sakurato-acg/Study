package com.hspedu.network;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main6 {


    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(System.in);


        String path = "src\\number.txt";
        File file = new File(path);

        OutputStream fos = new FileOutputStream(file);
        StringBuilder src = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int numbers = kb.nextInt();
            src.append(numbers).append(" ");
        }
        byte[] bytes = src.toString().getBytes();
        System.out.println(Arrays.toString(bytes));
        fos.write(bytes);
        fos.close();

        //----------------------------------------------------------------------------------//
        InputStream is = new FileInputStream(path);
        byte[] buffer = new byte[1024];
        int l;
        String str = "";
        while ((l = is.read(buffer)) != -1) {
            str = new String(buffer, 0, l);
            System.out.println(str);
        }
        String[] s = str.split(" ");
        int sum = 0;
        for (String value : s) {
            int val = Integer.parseInt(value);
            sum += val;
        }
        System.out.println("sum=" + sum);
        System.out.println("平均值=" + sum / s.length);
        is.close();
    }
}

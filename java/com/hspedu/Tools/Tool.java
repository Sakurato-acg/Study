package com.hspedu.Tools;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Tool {
    public static double sum(double n1,double n2){
        return n1+n2;
    }
    public static String ip2binary(String ip) {
        return Arrays.stream(ip.split("\\."))
                .map(s -> String.format("%8s", new BigInteger(s).toString(2)).
                        replaceAll(" ", "0"))
                .collect(Collectors.joining());
    }
        public static boolean panduan(int num) { //判断素数

        boolean isPrime = true;
        if (num > 0) {
            int k = (int) Math.sqrt(num);//k为num的正平方根，取整数
            for (int i = 2; i <= k; i++) {
                if (num % i == 0) {
                    isPrime = false;//不是素数
                    break;
                }
            }
        }
        return isPrime;

    }
    public static int getGongYueShu(int a, int b) {//求两个数的最大公约数
        int t;
        if(a < b){
            t = a;
            a = b;
            b = t;
        }
        int c = a % b;
        if(c == 0){
            return b;
        }else{
            return getGongYueShu(b, c);
        }
    }

    }


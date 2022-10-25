package com.数据结构与算法DataStructures.KMP;

import java.util.Arrays;
import java.util.Objects;

//https://www.bilibili.com/video/BV1hW411a7ys/?spm_id_from=333.788.recommend_more_video.-1
public class KMP {
    public static void main(String[] args) {
        String[] pattern =                  {"A", "B", "A", "B", "C", "A", "B", "A", "A"};
        String[] text = {"A", "B", "A", "B", "A", "B", "A", "B", "C", "A", "B", "A", "A"};
        search(text,pattern);
    }
    public static void search(String []text ,String [] pattern){
        int []prefix=new int[pattern.length];
        table(pattern,prefix,prefix.length);
        System.out.println(Arrays.toString(prefix));
        //[]text     len=m;
        //[]pattern  len=n;
        int i=0;int m=text.length;//原
        int j=0;int n= prefix.length;//目标
        while (i<m){
            if (j==n-1 && Objects.equals(text[i], pattern[j])){
                System.out.printf("Found pattern at %d\n",i-j);
                j=prefix[j];
            }
            if (Objects.equals(text[i], pattern[j])){
                i++;
                j++;
            }
            else {
                j=prefix[j];
                if (j==-1){
                    i++;
                    j++;
                }
            }

        }
    }
    public static void table(String[] pattern, int[] prefix, int length) {
        prefix[0] = 0;
        int len = 0;
        int index = 1;
        while (index < length) {
//            System.out.println("len="+len+" index= "+index);
            if (pattern[index] == pattern[len]) {
                len++;
                prefix[index] = len;
                index++;
            } else {
                if (len > 0) {
                    len = prefix[len - 1];
                }
                else {
                    prefix[index]=len;
                    index++;
                }
            }

        }

        for (int i = prefix.length-1; i >0; i--) {
            prefix[i]=prefix[i-1];
        }
        prefix[0]=-1;
    }
}
// 0 A B
// 1 A B A
// 2 A B A B
// 0 A B A B C
// 1 A B A B C A
// 2 A B A B C A B
// 3 A B A B C A B A
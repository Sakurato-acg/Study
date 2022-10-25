package com.数据结构与算法DataStructures.KMP;

import java.util.Arrays;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        String[] pattern =                  {"A", "B", "A", "B", "C", "A", "B", "A", "A"};
        String[] text = {"A", "B", "A", "B", "A", "B", "A", "B", "C", "A", "B", "A", "A"};
        int[] fix = new int[9];
        table(pattern, fix, fix.length);
        System.out.println(Arrays.toString(fix));
        search(text,pattern);
    }
    private static void table(String [] pattern,int  [] prefix,int length){
        prefix[0]=0;
        int len=0;
        int index=1;

        while (index<length){
            if (pattern[index] == pattern [len]){
                len++;
                prefix[index]=len;
                index++;
            }
            else {
                if (len>0){
                    len=prefix[len-1];
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
    private static void search(String []text ,String [] pattern){
        int []prefix=new int[pattern.length];
        table(pattern,prefix,prefix.length);

        //[]text     len=m;
        //[]pattern  len=n;
        int i=0;
        int m=text.length;
        int j=0;
        int n= prefix.length;
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
}

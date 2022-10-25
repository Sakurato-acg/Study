package com.hspedu.ch13.ArraysMethod;

import java.util.Arrays;
import java.util.Comparator;

public class Main2 {
    public static void main(String[] args) {
        int []arr={1,-1,8,0,20};
        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int  i1= (Integer) o1;
                int  i2= (Integer) o2;
                return i1-i2;
            }
        }) ;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr,1));
        //[-1, 0, 1, 8, 20]
        //2
    }
//    public static void bubble02(int[]arr){
//        for (int i = 0; i <arr.length-1 ; i++) {
//            for (int j = 0; j <arr.length-1-i ; j++) {
//                if (arr[j]>arr[j+1]){
//                    int temp=arr[j];
//                    arr[j]=arr[j+1];
//                    arr[j+1]=temp;
//                }
//            }
//        }
//    }
    public static void bubble02(int []arr, Comparator c){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {
                if (c.compare(arr[j],arr[j+1])>0){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}

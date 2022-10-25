package com.数据结构与算法DataStructures.查找.对分查找;


public class BinarySearch {
    public static void main(String[] args) {
//        int []a=new int[8];
//        for (int i = 0; i <a.length ; i++) {
//            a[i]= (int) (Math.random()*8+1);
//        }
//        System.out.println("排序前:"+Arrays.toString(a));
        int[] a = {1, 1, 7, 7, 7, 8, 8, 8};
//        s(a, 0, a.length - 1, 7);
        noReturn(a, 1);
//        System.out.printf("第%d个数\n",sort);
    }

    public static void noReturn(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] > key) {
                right = mid - 1;
            } else if (a[mid] < key) {
                left = mid + 1;
            } else {

                System.out.println(a[mid]);

                int index=mid;
                while ( index-1>=0 &&a[index-1]==key){
                    System.out.println(a[index-1]+" 位置是 "+(index-1));
                    index--;

                }
                int cur=mid;
                while (cur+1<= a.length-1 && a[cur+1]==key ){
                    System.out.println(a[cur+1]+"位置是"+(cur+1));
                    cur++;
                }
                return;
            }
        }
        System.out.println(-1);
    }

    public static void s(int[] a, int left, int right, int key) {
        int mid = (left + right) / 2;
        if (left > right) {
            System.out.println(-1);
        }
        if (a[mid] < key) {
            s(a, mid + 1, right, key);
        } else if (a[mid] > key) {
            s(a, left, mid - 1, key);
        } else {
            System.out.println(mid + "--");
            int index = mid;
            if (index - 1 != left) {
                while (a[index - 1] == a[index]) {
                    System.out.println(index - 1);
                    if (index - 1 == 0) {
                        break;
                    }
                    index--;
                }
            }
            System.out.println("--------------------");
            if (index + 1 != right) {
                while (a[mid + 1] == a[mid]) {
                    System.out.println(mid + 1);
                    if (mid + 1 == a.length - 1) {
                        break;
                    }
                    mid++;
                }
            }
        }
    }

    //小到大
    public static int sort(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        int out = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] > key) {
                right = mid - 1;
            } else if (a[mid] < key) {
                left = mid + 1;
            } else {
                out = mid;
                break;
            }
        }
        return ++out;
    }
}

package 刷题;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        int[] a = new int[9];
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            a[i] = kb.nextInt();
        }

        int s = 1;
        int n = a.length;
        int[] temp = new int[9];
        System.out.println(toString(a));
        while (s < n) {
            mergeSort(a, temp, s, n);
            System.out.println(toString(temp));
            s *= 2;
            mergeSort(temp, a, s, n);
            System.out.println(toString(a));
            s *= 2;
        }
    }

    public static String toString(int[] a) {
        String s = "";
        for (int j : a) {
            s = s + j + " ";
        }
        return s;
    }

    public static void mergeSort(int[] a, int[] temp, int s, int n) {
        int p = 0;
        while (p + 2 * s - 1 <= n - 1) {
            merge(a, temp, p, p + s - 1, p + 2 * s - 1);
            p += 2 * s;
        }
        if (p + s - 1 < n - 1) {
            merge(a, temp, p, p + s - 1, n - 1);
        } else {
            for (int i = p; i <= n - 1; i++) {
                temp[i] = a[i];
            }
        }
    }

    public static void merge(int[] a, int[] temp, int h, int m, int t) {
        int i = h, j = m + 1, k = h;
        while (i <= m && j <= t) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= t) {
            temp[k++] = a[j++];
        }
    }

}

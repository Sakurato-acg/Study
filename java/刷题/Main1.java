package 刷题;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (kb.hasNext()) {
            int ALL = kb.nextInt();
            int[] index = new int[ALL * (ALL + 1) / 2];
            int[] yanzhi = new int[ALL];
            for (int i = 0; i < yanzhi.length; i++) {
                yanzhi[i] = kb.nextInt();
            }
            int slaing = 0;
            for (int i = 0; i < yanzhi.length; i++) {
                for (int j = i; j < yanzhi.length; j++) {
                    for (int k = i; k <= j; k++) {
                        index[slaing] += yanzhi[k];
                    }
                    slaing++;
                }
            }
            int max = index[0];
            for (int j : index) {
                if (j > max) {
                    max = j;
                }
            }
            System.out.println(max);
        }
    }
}

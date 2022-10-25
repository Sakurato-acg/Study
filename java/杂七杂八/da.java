package 杂七杂八;

import java.util.Arrays;

public class da {
    int index;

    public void sort(int [] items) {
        for (int i = 0; i < items.length; i++) {
            int max = items[i];
            for (int j = i; j < items.length; j++) {
                if(items[j]>max){
                    index=j;
                    max=items[j];
                }
            }
//            swap(items[i], items[index]);
        }
    }


    public static void main(String[] args) {
        int []a={5,3,4,1,2};
        new da().sort(a);
        System.out.println(Arrays.toString(a));
    }
}

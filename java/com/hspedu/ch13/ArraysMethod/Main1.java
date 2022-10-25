package com.hspedu.ch13.ArraysMethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        //1.toString 转字
        int[] res = {1, 2, 9, 4};//[1, 2, 3, 4]
        System.out.println(Arrays.toString(res));

        //2.sort排序
        // Arrays.sort(res);
//        for (int i = 0; i <res.length ; i++) {
//
//            System.out.println(res[i]);
//
//     定制排序 两个参数（1）数组（2）内部类
        Integer[] integers = {1, 2, 9, 8, 7};
        Arrays.sort(integers, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i1 - i2;//递增
            }
        });
//        Arrays.sort(integers, (Comparator) (o1, o2) -> {
//            Integer i1 = (Integer) o1;
//            Integer i2 = (Integer) o2;
//            return i1 - i2;//递增
//        });
        System.out.println(Arrays.toString(integers));
        //System.arraycopy();
        //4.copyOf 数组元素的复制
        //5，fill  数组元素的填充
        //6.equals
        //7.aslist 将一组值，转化成list
        List<Integer>as=Arrays.asList(2,3,3,4,4);
    }
}

package com.数据结构与算法DataStructures.queue队列.优先队列;

import java.lang.reflect.Field;
import java.util.Arrays;

public class 优先队列_堆排序 {
    @SuppressWarnings("all")

    public static void main(String[] args) throws Exception {
        int[] tree = {9, 1, 41, 5, 42, 4, 7};
        MaxPriorityQueue<Integer> integerMaxPriorityQueue = new MaxPriorityQueue<>(tree.length);
        for (int i = 0; i < tree.length; i++) {
            integerMaxPriorityQueue.insert(tree[i]);
        }

        StringBuilder arr = get_arr(integerMaxPriorityQueue);
        System.out.println("入树后：" +arr);
        System.out.print("[");
        for (int i = 0; i < tree.length; i++) {
            Integer integer = integerMaxPriorityQueue.dalMax();
            if (i != tree.length - 1) {
                System.out.print(integer + ", ");
            } else {
                System.out.print(integer);
            }
        }
        System.out.println("]");
    }
    public static StringBuilder get_arr(Object integerMaxPriorityQueue) throws IllegalAccessException {
        Field[] fields = integerMaxPriorityQueue.getClass().getDeclaredFields();
        Object item = null;
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            item = field.get(integerMaxPriorityQueue);
            break;
        }

        Object[] item_arr = (Object[]) item;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < item_arr.length; i++) {
            stringBuilder.append(String.valueOf(item_arr[i]));
            if (i != item_arr.length-1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder;
    }
}

@SuppressWarnings("all")
class MaxPriorityQueue<T extends Comparable<T>> {
    private T[] items;

    private int N;

    @Override
    public String toString() {
        return "MaxPriorityQueue{" +
                "items=" + Arrays.toString(items) +
                '}';
    }

    public MaxPriorityQueue(int cap) {
        this.items = (T[]) new Comparable[cap + 1];

        this.N = 0;
    }

    public int size() {
        return N;
    }

    private boolean isEmpty() {
        return N == 0;
    }

    private boolean less(int i, int j) {

        return items[i].compareTo(items[j]) < 0;
    }

    private void swap(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }


    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    public T dalMax() {
        T max = items[1];

        swap(1, N);
        N--;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {
                swap(k / 2, k);
            }
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int max;
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }

            } else {
                max = 2 * k;
            }

            if (!less(k, max)) {
                break;
            }
            swap(k, max);

            k = max;
        }
    }
}

@SuppressWarnings("all")
class MinPriorityQueue<T extends Comparable<T>> {

    private T[] items;

    private int N;

    public MinPriorityQueue(int cap) {
        this.items = (T[]) new Comparable[cap + 1];
        this.N = 0;
    }

    public int size() {
        return N;
    }

    private boolean isEmpty() {
        return N == 0;
    }

    private boolean less(int i, int j) {

        return items[i].compareTo(items[j]) < 0;
    }

    private void swap(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }


    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    public T dalMin() {
        T min = items[1];

        swap(1, N);
        N--;
        sink(1);
        return min;
    }

    private void swim(int k) {
        while (k > 1) {
            if (less(k, k / 2)) {
                swap(k, k / 2);
            }
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int min;
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    min = 2 * k;
                } else {
                    min = 2 * k + 1;
                }

            } else {
                min = 2 * k;
            }

            if (less(k, min)) {
                break;
            }
            swap(k, min);

            k = min;
        }
    }
}



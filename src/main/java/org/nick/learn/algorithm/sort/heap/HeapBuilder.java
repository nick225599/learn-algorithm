package org.nick.learn.algorithm.sort.heap;

import org.nick.learn.algorithm.utils.ArrayUtils;

public class HeapBuilder {

    public static void buildMaxHeap(int[] arr) {
        // 从后往前处理
        for (int i = arr.length - 1; i > arr.length / 2; i--) {
            //TODO sunchuansheng 20240114 23:40 构建大顶堆的时候还需要重复排序
            for (int t = i; t > 0; ) {
                int parentIndex = (t - 1)/2;
                if (arr[parentIndex] < arr[t]) {
                    ArrayUtils.swap(arr, parentIndex, t);
                    HeapPrinter.printHeap(arr);
                    System.out.println("-------------------");
                }
                t = parentIndex;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(1 / 2);
    }

    public static void buildMinHeap(int[] arr) {

    }
}

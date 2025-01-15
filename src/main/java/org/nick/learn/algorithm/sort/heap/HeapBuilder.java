package org.nick.learn.algorithm.sort.heap;

import org.nick.learn.algorithm.utils.ArrayUtils;
import org.nick.learn.algorithm.utils.CommonUtils;

public class HeapBuilder {

    public static void buildMaxHeap(int[] arr) {
        // 从后往前处理
        for (int i = arr.length - 1; i > arr.length / 2; i--) {

            //TODO sunchuansheng 20240114 23:40 构建大顶堆的时候还需要重复排序
            for (int t = i; t > 0; ) {
                int top = (t - 1) / 2;
                if (arr[top] < arr[t]) {
                    ArrayUtils.swap(arr, top, t);
                    HeapPrinter.printHeap(arr);
                    CommonUtils.printLine();
                } else {
                    t = top;
                }
            }
        }
    }

    private static void buildMaxHeapCheckIfNeedSwap(int[] arr, int topIndex){

    }

    public static void buildMinHeap(int[] arr) {

    }
}

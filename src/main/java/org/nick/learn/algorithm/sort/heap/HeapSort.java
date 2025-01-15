package org.nick.learn.algorithm.sort.heap;

import static org.nick.learn.algorithm.utils.ArrayUtils.swap;

public class HeapSort {

    public static void heapSort(int[] arr){
        HeapBuilder.heapifyMaxTop(arr, arr.length);
        for(int i = arr.length - 1; i>=0; i--){
            swap(arr, 0, i);
            HeapBuilder.heapifyMaxTop(arr, i);
        }
        HeapPrinter.printHeap(arr);
    }
}

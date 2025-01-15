package org.nick.learn.algorithm.sort.heap;

import org.nick.learn.algorithm.utils.ArrayUtils;
import org.nick.learn.algorithm.utils.CommonUtils;

public class HeapBuilder {

    public static void buildMaxHeapBackwards(int[] arr) {
        // 从后往前处理
        for (int i = arr.length - 1; i > arr.length / 2; i--) {
            for (int j = i; j > 0; ) {
                boolean swapped = buildMaxHeapCheckIfNeedSwap(arr, j);
                if (swapped) {
                    j = i;
                } else {
                    j = (j - 1) / 2;
                }
            }
        }
    }

    /**
     * @return true: swapped; false: not swapped
     */
    private static boolean buildMaxHeapCheckIfNeedSwap(int[] arr, int childNodeIndex) {
        int parentNodeIndex = (childNodeIndex - 1) / 2;
        if (arr[parentNodeIndex] < arr[childNodeIndex]) {
            ArrayUtils.swap(arr, parentNodeIndex, childNodeIndex);
            return true;
        }
        return false;
    }



    public static void buildMinHeapForwards(int[] arr) {
        // 从前往后处理
        for (int i = 0; i < arr.length / 2; i++) {
            int leftNodeIndex = i * 2 + 1;
            boolean swappedL = buildMinHeapCheckIfNeedSwap(arr, leftNodeIndex);
            boolean swappedR = false;
            int rightNodeIndex = leftNodeIndex + 1;
            if (rightNodeIndex < arr.length) {
                swappedR =  buildMinHeapCheckIfNeedSwap(arr, rightNodeIndex);
            }
            if(swappedL || swappedR){
                i = 0;
            }
        }
    }

    private static boolean buildMinHeapCheckIfNeedSwap(int[] arr, int childNodeIndex) {
        int parentNodeIndex = (childNodeIndex - 1) / 2;
        if (arr[parentNodeIndex] > arr[childNodeIndex]) {
            ArrayUtils.swap(arr, parentNodeIndex, childNodeIndex);

            HeapPrinter.printHeap(arr);
            CommonUtils.printLine();

            return true;

        }
        return false;
    }
}

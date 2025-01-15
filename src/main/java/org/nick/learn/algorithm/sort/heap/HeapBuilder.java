package org.nick.learn.algorithm.sort.heap;

import org.nick.learn.algorithm.utils.ArrayUtils;
import org.nick.learn.algorithm.utils.CommonUtils;

public class HeapBuilder {

    //TODO sunchuansheng 2024-01-15 12:07 从前往后遍历构建小顶堆咋构建？
    public static void buildMaxHeapBackwards(int[] arr) {
        // 从后往前处理
        for (int i = arr.length - 1; i > arr.length / 2; i--) {
            for (int j = i; j > 0; ) {
                boolean swapped = buildMaxHeapBackwardsCheckIfNeedSwap(arr, j);
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
    private static boolean buildMaxHeapBackwardsCheckIfNeedSwap(int[] arr, int childNodeIndex) {
        int parentNodeIndex = (childNodeIndex - 1) / 2;
        if (arr[parentNodeIndex] < arr[childNodeIndex]) {
            ArrayUtils.swap(arr, parentNodeIndex, childNodeIndex);
            return true;
        }
        return false;
    }

    public static void buildMinHeap(int[] arr) {

    }
}

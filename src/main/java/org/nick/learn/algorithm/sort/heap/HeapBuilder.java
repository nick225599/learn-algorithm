package org.nick.learn.algorithm.sort.heap;

import org.nick.learn.algorithm.utils.CommonUtils;

import static org.nick.learn.algorithm.utils.ArrayUtils.swap;


public class HeapBuilder {

    public static void heapifyMaxTop(int[] arr) {
        heapifyMaxTop(arr, arr.length);
    }
    public static void heapifyMaxTop(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            HeapBuilder.heapifyMaxTop(arr, n, i);
        }
    }

    public static void heapifyMinTop(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            HeapBuilder.heapifyMinTop(arr, n, i);
        }
    }

    private static void heapifyMinTop(int[] arr, int n, int i) {
        while (true) {
            int minIdx = i;
            int leftNode = i * 2 + 1;
            if (leftNode < n && arr[leftNode] < arr[minIdx]) {
                minIdx = leftNode;
            }
            int rightNode = i * 2 + 2;
            if (rightNode < n && arr[rightNode] < arr[minIdx]) {
                minIdx = rightNode;
            }
            if (minIdx == i) {
                // 不用交换

                // 也不用向下检查
                break;
            } else {
                // 交换
                swap(arr, i, minIdx);

                // 向下检查被交换的那个元素
                i = minIdx;
            }
        }

    }

    private static void heapifyMaxTop(int[] arr, int n, int i) {
        while (true) {
            int maxIndex = i;
            int leftNode = i * 2 + 1;
            if (leftNode < n && arr[leftNode] > arr[maxIndex]) {
                maxIndex = leftNode;
            }
            int rightNode = i * 2 + 2;
            if (rightNode < n && arr[rightNode] > arr[maxIndex]) {
                maxIndex = rightNode;
            }
            if (maxIndex == i) {
                // 不用交换

                // 也不用向下检查
                break;
            } else {
                // 交换
                swap(arr, i, maxIndex);

                // 向下检查被交换的那个元素
                i = maxIndex;
            }
        }


    }

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
            swap(arr, parentNodeIndex, childNodeIndex);
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
                swappedR = buildMinHeapCheckIfNeedSwap(arr, rightNodeIndex);
            }
            if (swappedL || swappedR) {
                i = 0;
            }
        }
    }

    private static boolean buildMinHeapCheckIfNeedSwap(int[] arr, int childNodeIndex) {
        int parentNodeIndex = (childNodeIndex - 1) / 2;
        if (arr[parentNodeIndex] > arr[childNodeIndex]) {
            swap(arr, parentNodeIndex, childNodeIndex);

            HeapPrinter.printHeap(arr);
            CommonUtils.printLine();

            return true;

        }
        return false;
    }
}

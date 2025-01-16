package org.nick.learn.algorithm.sort.heap;

import org.nick.learn.algorithm.utils.ArrayUtils;
import org.nick.learn.leetcode.problem23.ListNode;

public class HeapPrinter {
    public static void printHeap(ListNode[] heap) {
        int[] intHeap = new int[heap.length];
        for (int i = 0; i < heap.length; i++) {
            if (null != heap[i]) {
                intHeap[i] = heap[i].val;
            }
        }
        HeapPrinter.printHeap(intHeap);
    }

    // 堆化函数
    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            ArrayUtils.swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // 堆排序函数
    void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // 打印树状堆的函数
    public static void printHeap(int[] arr) {
        int n = arr.length;
        int height = (int) (Math.log(n) / Math.log(2)) + 1; // 计算堆的高度
        int maxWidth = (int) Math.pow(2, height) * 4; // 最大宽度，用于对齐

        int index = 0;
        for (int i = 0; i < height; i++) {
            int numNodes = (int) Math.pow(2, i); // 当前层的节点数
            int nodeSpacing = maxWidth / (numNodes + 1); // 节点之间的间距
            for (int j = 0; j < numNodes && index < n; j++) {
                for (int k = 0; k < nodeSpacing; k++) {
                    System.out.print(" ");
                }
                System.out.print(arr[index]);
                index++;
            }
            System.out.println();
        }
    }
}
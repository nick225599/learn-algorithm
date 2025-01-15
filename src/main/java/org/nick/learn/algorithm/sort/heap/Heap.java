package org.nick.learn.algorithm.sort.heap;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.utils.ArrayUtils;

import static org.nick.learn.algorithm.utils.ArrayUtils.swap;

@Slf4j
public class Heap {
//    private int[] a; // 数组，从下标1开始存储数据
//    private int n;  // 堆可以存储的最大数据个数
//    private int count; // 堆中已经存储的数据个数
//
//    public Heap(int capacity) {
//        a = new int[capacity + 1];
//        n = capacity;
//        count = 0;
//    }
//
//    public void insert(int data) {
//        if (count >= n) return; // 堆满了
//        ++count;
//        a[count] = data;
//        int i = count;
//        while (i/2 > 0 && a[i] > a[i/2]) { // 自下往上堆化
//            swap(a, i, i/2); // swap()函数作用：交换下标为i和i/2的两个元素
//            i = i/2;
//        }
//    }
//
//    public void removeMax() {
//        if (count == 0) return; // 堆中没有数据
//        a[1] = a[count];
//        --count;
//        heapify(a, count, 1);
//    }
//
//    private void heapify(int[] a, int n, int i) { // 自上往下堆化
//        while (true) {
//            int maxPos = i;
//            if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
//            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
//            if (maxPos == i) break;
//            swap(a, i, maxPos);
//            i = maxPos;
//        }
//    }

    private static void buildHeap(int[] a, int n) {
        // 从最后一个非叶子节点开始，向上构建堆
        for (int i = n / 2 - 1; i >= 0; --i) {
            heapify(a, n, i);
        }
    }

    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            int leftIndex = i * 2 + 1;
            int rightIndex = i * 2 + 2;
            if (leftIndex < n && a[i] < a[leftIndex]) maxPos = leftIndex;
            if (rightIndex < n && a[maxPos] < a[rightIndex]) maxPos = rightIndex;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }
}

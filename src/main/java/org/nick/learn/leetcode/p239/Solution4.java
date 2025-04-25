package org.nick.learn.leetcode.p239;


public class Solution4 {

    static class MaxHeap {
        private int[] heap; // 存储元素值
        private int[] indices; // 存储元素索引
        private int size; // 当前堆中元素个数
        private int capacity; // 堆的最大容量

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.heap = new int[capacity];
            this.indices = new int[capacity];
            this.size = 0;
        }

        // 插入元素
        public void push(int value, int index) {
            if (size == capacity) {
                throw new RuntimeException("heap is full");
            }
            heap[size] = value;
            indices[size] = index;
            swim(size);
            size++;
        }

        // 弹出堆顶元素
        public void pop() {
            if (size == 0) return;
            size--;
            if (size > 0) {
                heap[0] = heap[size];
                indices[0] = indices[size];
                sink(0);
            }
        }

        // 获取堆顶元素
        public int[] peek() {
            if (size == 0) return null;
            return new int[]{heap[0], indices[0]};
        }

        // 上浮操作
        private void swim(int i) {
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (heap[parent] >= heap[i]) break;
                swap(parent, i);
                i = parent;
            }
        }

        // 下沉操作
        private void sink(int i) {
            int n = size;
            while (2 * i + 1 < n) {
                int child = 2 * i + 1;
                if (child + 1 < n && heap[child + 1] > heap[child]) {
                    child++;
                }
                if (heap[i] >= heap[child]) break;
                swap(i, child);
                i = child;
            }
        }

        // 交换两个元素
        private void swap(int i, int j) {
            int tempValue = heap[i];
            heap[i] = heap[j];
            heap[j] = tempValue;

            int tempIndex = indices[i];
            indices[i] = indices[j];
            indices[j] = tempIndex;
        }

        // 移除指定索引的元素（用于清理无效元素）
        public void removeInvalid(int left) {
            while (size > 0 && indices[0] < left) {
                pop();
            }
        }
    }

    // 主函数：求滑动窗口最大值
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        int n = nums.length;
        if (k > n) return new int[0];

        MaxHeap maxHeap = new MaxHeap(k); // 初始容量为 k
        int[] result = new int[n - k + 1];
        int resIndex = 0;

        for (int i = 0; i < n; i++) {
            // 将当前元素加入堆
            maxHeap.push(nums[i], i);

            // 当窗口形成后开始计算最大值
            if (i >= k - 1) {
                // 移除堆中不在窗口范围内的元素
                 maxHeap.removeInvalid(i - k + 1);
                // 堆顶即为当前窗口的最大值
                result[resIndex++] = maxHeap.peek()[0];
            }
        }

        return result;
    }
}
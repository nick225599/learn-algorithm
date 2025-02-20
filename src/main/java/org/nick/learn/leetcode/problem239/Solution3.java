package org.nick.learn.leetcode.problem239;

public class Solution3 {

    // AI 优化了一下，自己再修复了一下错误，不会超时了，还是运行时间 96ms，基本垫底了
    static class MaxTopHeap {
        int[][] elements;
        int capacity;
        int size = 0;

        public MaxTopHeap(int capacity) {
            this.capacity = capacity;
            this.elements = new int[capacity][2];
        }

        public boolean add(int value, int indexOfValue) {
            if (isFull()) {
                return false;
            }

            elements[size] = new int[]{value, indexOfValue};
            heapify(size);
            size++;
            return true;
        }

        private void heapify(int index) {
            while (index > 0) {
                int parentIndex = (index - 1) / 2;
                if (elements[parentIndex][0] < elements[index][0]) {
                    swap(elements, parentIndex, index);
                    index = parentIndex;
                } else {
                    break;
                }
            }
        }

        private void swap(int[][] arr, int l, int r) {
            int[] tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }

        public int[] peek() {
            return elements[0];
        }

        public int[] pop() {
            if (isEmpty()) {
                throw new RuntimeException("heap is empty");
            }
            int[] top = elements[0];
            swap(elements, 0, size - 1);
            size--;
            heapifyFormTopToBottom(0);
            return top;
        }

        private void heapifyFormTopToBottom(int startIndex) {
            if (startIndex >= size) {
                return;
            }

            int largest = startIndex;
            int leftNodeIndex = startIndex * 2 + 1;
            int rightNodeIndex = startIndex * 2 + 2;

            if (leftNodeIndex < size && elements[leftNodeIndex][0] > elements[largest][0]) {
                largest = leftNodeIndex;
            }

            if (rightNodeIndex < size && elements[rightNodeIndex][0] > elements[largest][0]) {
                largest = rightNodeIndex;
            }

            if (largest != startIndex) {
                swap(elements, startIndex, largest);
                heapifyFormTopToBottom(largest);
            }
        }

        public boolean isFull() {
            return size == capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    // 大顶堆法
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        MaxTopHeap heap = new MaxTopHeap(nums.length);

        for (int i = 0; i < nums.length; i++) {
            // 移除过期元素
            while (!heap.isEmpty() && heap.peek()[1] <= i - k) {
                heap.pop();
            }

            // 插入新元素
            heap.add(nums[i], i);

            // 当窗口形成时，记录最大值
            if (i >= k - 1) {
                result[i - k + 1] = heap.peek()[0];
            }
        }

        return result;
    }
}
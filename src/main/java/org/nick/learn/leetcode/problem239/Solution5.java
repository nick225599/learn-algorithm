package org.nick.learn.leetcode.problem239;

public class Solution5 {

    static class MaxHeap {
        private final int[] elements;
        private final int[] indexOfElements;
        private final int capacity; // 堆的最大容量
        private int size = 0; // 当前堆中元素个数
        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.elements = new int[capacity];
            this.indexOfElements = new int[capacity];
        }
        public void add(int value, int indexOfValue) {
            if (isFull()) {
                throw new RuntimeException("max heap is full");
            }
            elements[size] = value;
            indexOfElements[size] = indexOfValue;
            this.swim(size);
            size++;
        }
        public void pop() {
            if (size == 0) {
                return;
            }
            size--;
            elements[0] = elements[size];
            indexOfElements[0]  = indexOfElements[size];
            this.sink(0);
        }
        public int[] peek() {
            if(size == 0){
                return null;
            }
            return new int[]{elements[0], indexOfElements[0]};
        }

        // 上浮操作
        private void swim(int childIndex) {
            while((childIndex - 1)/2 >= 0){
                int parentIndex = (childIndex - 1)/2;
                if (elements[parentIndex] >= elements[childIndex]) {
                    break;
                }
                this.swap(parentIndex, childIndex);
                childIndex = parentIndex; // 继续执行上一层
            }
        }

        // 下沉操作
        private void sink(int i) {
            // 省事儿，不用进行无意义的递归
            int parentIndex = i;
            while (parentIndex * 2 + 1 < size) {
                int childIndex = parentIndex * 2 + 1;
                if (childIndex + 1 < size
                        && (elements[childIndex] < elements[childIndex + 1])) {
                    childIndex = childIndex + 1;
                }
                if (elements[parentIndex] >= elements[childIndex]) {
                    break;
                }
                this.swap(parentIndex, childIndex);
                parentIndex = childIndex; // 处理下一层
            }
        }
        private void swap(int l, int r) {
            int tmp = elements[l];
            elements[l] = elements[r];
            elements[r] = tmp;
            int tmp2 = indexOfElements[l];
            indexOfElements[l] = indexOfElements[r];
            indexOfElements[r] = tmp2;
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

        // 1. 建立一个大顶堆
        MaxHeap maxHeap = new MaxHeap(nums.length);
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i], i);
            if (i >= k - 1) {
                while (!maxHeap.isEmpty() && maxHeap.peek()[1] <= i - k) {
                    maxHeap.pop();
                }
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }
        return result;
    }
}

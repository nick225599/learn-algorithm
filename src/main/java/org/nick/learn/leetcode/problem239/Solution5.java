package org.nick.learn.leetcode.problem239;

public class Solution5 {

    // 自己实现的大顶堆要 88 ms

    // 参照 AI 生成的大顶堆解法，review 并优化一下自己的解法
    static class MaxHeap {
        private int[][] elements;
        private int size = 0; // 当前堆中元素个数
        private int capacity; // 堆的最大容量

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.elements = new int[capacity][2];
        }

        public void add(int value, int indexOfValue) {
            if (isFull()) {
                throw new RuntimeException("max heap is full");
            }

            elements[size] = new int[]{value, indexOfValue};
            this.swim(size);
            size++;
        }

        public void pop() {
            if (isEmpty()) {
                return;
            }
            size--;
            this.swap(elements, 0, size);
            this.sink(0);
        }

        public int[] peek() {
            if(isEmpty()){
                return null;
            }
            return new int[]{elements[0][0], elements[0][1]};
        }

        // 上浮操作
        private void swim(int childIndex) {
            while((childIndex - 1)/2 >= 0){
                int parentIndex = (childIndex - 1)/2;
                if (elements[parentIndex][0] >= elements[childIndex][0]) {
                    break;
                }
                this.swap(elements, parentIndex, childIndex);
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
                        && (elements[childIndex][0] < elements[childIndex + 1][0])) {
                    childIndex = childIndex + 1;
                }
                if (elements[parentIndex][0] >= elements[childIndex][0]) {
                    break;
                }
                this.swap(elements, parentIndex, childIndex);
                parentIndex = childIndex; // 处理下一层
            }

        }

        private void swap(int[][] arr, int l, int r) {
            int[] tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
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

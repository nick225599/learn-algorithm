package org.nick.learn.leetcode.p239;

public class Solution2 {

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

            this.heapify(size);

            size++;
            return true;
        }

        private void heapify(int index) {
            int parentIndex = index;
            while (parentIndex >= 0) {
                if (elements[parentIndex][0] < elements[index][0]) {
                    this.swap(elements, parentIndex, index);
                }

                index = parentIndex;
                parentIndex = index % 2 == 0
                        ? index / 2 - 1
                        : (index - 1) / 2;
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
            this.swap(elements, 0, size - 1);
            size--;

            this.heapifyFormTopToBottom(0);

            return top;
        }

        private void heapifyFormTopToBottom(int startIndex) {
            if (startIndex >= size) {
                return;
            }

            int leftNodeIndex = startIndex * 2 + 1;
            if (leftNodeIndex < size && elements[startIndex][0] < elements[leftNodeIndex][0]) {
                this.swap(elements, startIndex, leftNodeIndex);
                heapifyFormTopToBottom(leftNodeIndex);
            }

            int rightNodeIndex = startIndex * 2 + 2;
            if (rightNodeIndex < size && elements[startIndex][0] < elements[rightNodeIndex][0]) {
                this.swap(elements, startIndex, rightNodeIndex);
                heapifyFormTopToBottom(rightNodeIndex);
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
        // 1. 建立一个大顶堆
        int[] result = new int[nums.length - k + 1];
        MaxTopHeap heap = new MaxTopHeap(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                heap.add(nums[i], i);
                if (i == k - 1) {
                    result[i - k + 1] = heap.peek()[0];
                }
            }
            if (i >= k) {
                heap.add(nums[i], i);

                boolean topNodeIsExpired;
                do {
                    int[] topNode = heap.peek();
                    topNodeIsExpired = topNode[1] <= (i - k);
                    if(topNodeIsExpired){
                        heap.pop();
                    }
                } while (topNodeIsExpired);

                result[i - k + 1] = heap.peek()[0];
            }
        }
        return result;
    }


}

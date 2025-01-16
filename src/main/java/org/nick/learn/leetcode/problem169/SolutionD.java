package org.nick.learn.leetcode.problem169;


import org.nick.learn.algorithm.sort.heap.HeapPrinter;

/**
 * 堆排序
 * 时间复杂度 O(nlogn)
 * 空间复杂度 O(1)
 */
public class SolutionD {
    public int majorityElement(int[] nums) {
        // 堆排序 + 取中间数
        this.heapSort(nums, nums.length);
        return nums[nums.length / 2];
    }

    public void heapSort(int[] nums, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        HeapPrinter.printHeap(nums);

        for (int i = n - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }

    private void heapify(int[] nums, int n, int i) {
        int max = i;
        int l = i * 2 + 1;
        if (l < n && nums[l] > nums[max]) {
            max = l;
        }

        int r = l + 1;
        if (r < n && nums[r] > nums[max]) {
            max = r;
        }

        if (max != i) {
            swap(nums, i, max);
            heapify(nums, n, max);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

package org.nick.learn.leetcode.p215;

import java.util.Arrays;

public class P215Solution1 {

    // 快排
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        this.quicksort(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
        return -1;
    }

    private void quicksort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int tIdx = i;
        int tNum = nums[i];
        for (int f = tIdx + 1; f <= j; f++) {
            if (nums[f] < tNum) {
                this.swap(nums, f, tIdx);
                tIdx++;
            }
        }
        this.quicksort(nums, i, tIdx - 1);
        this.quicksort(nums, tIdx, j);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

package org.nick.learn.leetcode.p912;

public class P912Solution5 {
    // 快排
    public int[] sortArray(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = lomutoPartition(nums, l, r);
            this.quickSort(nums, l, pos - 1);
            this.quickSort(nums, pos + 1, r);
        }
    }

    private int lomutoPartition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int j = l;
        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                this.swap(nums, i, j);
                j++;
            }
        }
        this.swap(nums, j, r);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}

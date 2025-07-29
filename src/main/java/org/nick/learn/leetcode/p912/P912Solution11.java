package org.nick.learn.leetcode.p912;

public class P912Solution11 {

    public int[] sortArray(int[] nums) {
        this.quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    // hoare 分区法，以右边界值为基准值
    private void quicksort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = nums[r], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < pivot);
            do j--; while (nums[j] > pivot);
            if (i < j) {
                this.swap(nums, i, j);
            }
        }
        // [1, 2]
        // [2, 1]
        // [1, 1]
        this.quicksort(nums, l, i - 1);
        this.quicksort(nums, i, r);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

package org.nick.learn.leetcode.p912;

public class P912Solution1 {
    public int[] sortArray(int[] nums) {
        this.quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l;
        int target = nums[l];
        for (int k = i + 1; k <= r; k++) {
            if (nums[k] < target) {
                this.swap(nums, k, i);
                i++;
            }
        }
        if (i != r && nums[i] < nums[r]) {
            this.swap(nums, i, r);
        }
        this.quicksort(nums, l, i - 1);
        this.quicksort(nums, i + 1, r);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

package org.nick.learn.leetcode.p912;

public class P912Solution1 {
    public int[] sortArray(int[] nums) {
        this.quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int l, int r) {
        System.out.println("l: " + l + ", r: " + r);
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
        if (i != l) {
            swap(nums, i, r);
        }
        // 怎么提前结束，避免无限递归死循环？
        this.quicksort(nums, l, i - 1);
        if (i == l) {
            this.quicksort(nums, i + 1, r);
        } else {
            this.quicksort(nums, i, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

package org.nick.learn.leetcode.p912;

public class P912Solution6 {

    // 快排 Lomuto 分区法，选最左侧元素作为 pivot
    public int[] sortArray(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = lomutoParitition(nums, l, r);
            this.quickSort(nums, l, pos - 1);
            this.quickSort(nums, pos + 1, r);
        }
    }

    private int lomutoParitition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int j = l - 1;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < pivot && i != j + 1) {
                j++;
                this.swap(nums, i, j);
            }
        }
        if (j != l - 1) {
            this.swap(nums, l, j);
            return j;
        } else {
            return j + 1;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}

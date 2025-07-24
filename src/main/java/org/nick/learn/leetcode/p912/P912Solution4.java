package org.nick.learn.leetcode.p912;

public class P912Solution4 {
    // 快排
    public int[] sortArray(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int position = this.partition(nums, l, r);
            this.quickSort(nums, l, position - 1);
            this.quickSort(nums, position + 1, r);
        }
    }

    // 选择头元素作为 pivot
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int j = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < pivot) {
                this.swap(nums, i, j);
                j++;
            }
        }
        this.swap(nums, l, j - 1);
        return j - 1;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}

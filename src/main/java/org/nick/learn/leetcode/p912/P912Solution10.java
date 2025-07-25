package org.nick.learn.leetcode.p912;

public class P912Solution10 {

    // 为啥不会超时?
    public int[] sortArray(int[] nums) {
        this.quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int l, int r) {
        if (l == r) return ;
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < x);

            do {
                j--;
            } while (nums[j] > x);

            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        quicksort(nums, l, j);
        quicksort(nums, j + 1, r);
    }
}

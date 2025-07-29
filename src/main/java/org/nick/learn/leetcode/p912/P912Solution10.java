package org.nick.learn.leetcode.p912;

public class P912Solution10 {

    public int[] sortArray(int[] nums) {
        this.quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int l, int r) {
        if (l >= r) return;
        if(l < 0 || r > nums.length - 1){
            return;
        }
        int x = nums[r], i = l - 1, j = r + 1;
        while (i < j) {
            int tmp;
            do {
                i++;
                tmp = nums[i];
            } while (tmp < x);
            do {
                j--;
                tmp = nums[j];
            } while (tmp > x);
            if (i < j) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        // 排序 [1, 2] 时，循环结束 i = j = 0
        // 排序 [2, 1] 时，循环结束 i = 1, j = 0
        // 排序 [1, 1] 时，循环结束 i = 1, j = 0
        quicksort(nums, l, j);
        quicksort(nums, j + 1, r);
    }
}

package org.nick.learn.leetcode.p912;

public class P912Solution7 {

    // 快排 Lomuto 分区法，选最右侧元素作为 pivot
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

    /**
     * 快排 Lomuto 分区法，选最右侧元素作为 pivot，
     * 初始分区下标为 l
     *
     * 同样元素的数组依旧超时
     */
    private int lomutoParitition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int j = l;
        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                if (i != j) {
                    this.swap(nums, i, j);
                }
                j++;
            }
        }
        if (r != j) {
            this.swap(nums, r, j);
        }
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}

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

    /**
     * 快排 Lomuto 分区法，选最左侧元素作为 pivot，
     * 初始分区下标为 l - 1
     * 写错了
     *
     * 以前这个错在哪？
     * 下标 j = l - 1 就没想好要怎么控制分区指针
     */
    private int lomutoParitition1(int[] nums, int l, int r) {
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

    /**
     * 快排 Lomuto 分区法，选最左侧元素作为 pivot，
     * 初始分区下标为 l + 1
     * 写对了
     *
     * 但是最后需要进行 j - 1 的修正
     */
    private int lomutoParitition2(int[] nums, int l, int r) {
        int pivot = nums[l];
        int j = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < pivot) {
                if (i != j) {
                    this.swap(nums, i, j);
                }
                j++;
            }
        }
        if (l != j - 1) {
            this.swap(nums, l, j - 1);
        }
        return j - 1;
    }

    /**
     * 快排 Lomuto 分区法，选最左侧元素作为 pivot，
     * 初始分区下标为 l
     * 写对了
     *
     * 代码相对最干净，但是遇上所有元素都相等的数组时，超时了
     */
    private int lomutoParitition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < pivot) {
                j++;
                if (i != j) {
                    this.swap(nums, i, j);
                }
            }
        }
        if (l != j) {
            this.swap(nums, l, j);
        }
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}

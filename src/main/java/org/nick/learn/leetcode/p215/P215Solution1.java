package org.nick.learn.leetcode.p215;

public class P215Solution1 {
    private int k;

    // 快排
    // 在递增或递减区间时会退化至 O(n^2)
//    Lomuto 分区法（Lomuto's Partition Scheme）
    // 最左元素为轴
    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        int n = nums.length;
        this.quicksort(nums, 0, n - 1);
        return nums[n - k];
    }

    private void quicksort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int position = this.partition(nums, l, r);
        if (position < nums.length - k) {
            this.quicksort(nums, position + 1, r);
        } else if (nums.length - k < position) {
            this.quicksort(nums, l, position - 1);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int j = l - 1;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < pivot) {
                j++;
                this.swap(nums, i, j);
            }
        }
        this.swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

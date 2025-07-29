package org.nick.learn.leetcode.p215;

public class P215Solution4 {

    // 快排双指针分区
    // 11ms, 击败 87%
    public int findKthLargest(int[] nums, int k) {
        this.quicksort(nums, nums.length - k);
        return nums[nums.length - k];
    }

    private void quicksort(int[] nums, int k) {
        this.quicksort(nums, 0, nums.length - 1, k);
    }

    private void quicksort(int[] nums, int l, int r, int k) {
        if (l < r) {
            int p = nums[l];
            int i = l - 1;
            int j = r + 1;

            while (i < j) {
                do i++; while (nums[i] < p);
                do j--; while (nums[j] > p);
                if (i < j) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
            // 因为有剪枝，实际不用排完整个数组，相比于标准单轴双指针快排，这个实际时间复杂度常数系数要低一些
            // 官方题解表示时间复杂度仅 O(n)，不过证明比较复杂，参见《算法导论 9.2 期望为线性的选择算法》
            if (k <= j) {
                quicksort(nums, l, j, k);
            } else {
                quicksort(nums, j + 1, r, k);
            }
        }
    }
}

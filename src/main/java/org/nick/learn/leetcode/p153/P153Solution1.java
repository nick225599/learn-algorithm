package org.nick.learn.leetcode.p153;

public class P153Solution1 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n - 1]) {
            return nums[0];
        }
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[l] <= nums[m] // [l, m] 是递增的
                    && nums[l] > nums[r] // 且左半区间的右边界小于左半边的左边界，那么最小值在右半边界
            ) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}

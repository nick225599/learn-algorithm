package org.nick.learn.leetcode.p34;

public class P34Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        if (n == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }

        // 1. 找到 < target 的最大值的右下标
        //TODO nick 20250722 咋找？？？
        int l = 0;
        int r = n - 1;
        int t = nums[0];
        while (l <= r) {
            int m = (r + l) / 2;
            if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        // 2. 找到 > target 的最小值的左下标

    }
}

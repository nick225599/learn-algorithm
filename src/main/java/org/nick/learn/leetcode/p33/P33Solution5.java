package org.nick.learn.leetcode.p33;

public class P33Solution5 {


    // 0ms 击败 100%
    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            // 1. target < nums[m]
            //   1.1 [l, m - 1] 有序
            //        1.1.1 nums[l] <= target 在 [l, m - 1] 继续找
            //        1.1.2 target < nums[l]  在 [m + 1, r] 继续寻找

            //   1.2 [l, m - 1] 无序，在 [l, m - 1] 继续找

            // 2. target > nums[m]
            //   2.1 [m + 1, r] 有序
            //     2.1.1 target <= nums[r] 在 [m + 1, r] 继续找
            //     2.2.2 nums[r] < target 在[l, m - 1] 继续找
            //   2.2 [m + 1, r] 无序，在 [m + 1, r] 继续找

            if (target < nums[m]) {
                if (nums[l] <= nums[m]) {
                    if (nums[l] <= target) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                } else {
                    r = m - 1;
                }
            } else if (target > nums[m]) {
                if (nums[m] <= nums[r]) {
                    if (target <= nums[r]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                } else {
                    l = m + 1;
                }
            } else {
                return m;
            }
        }
        return -1;
    }


}

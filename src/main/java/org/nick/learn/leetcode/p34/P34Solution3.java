package org.nick.learn.leetcode.p34;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P34Solution3 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        if (n == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }

        int l = 0;
        int r = n - 1;
        int left = -1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (target < nums[m]) {
                r = m - 1;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
                left = m;
            }
        }
        if (left == -1) {
            return new int[]{-1, -1};
        }

        l = 0;
        r = n - 1;
        int right = -1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (target < nums[m]) {
                r = m - 1;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                l = m + 1;
                right = m;
            }
        }
        return new int[]{left, right};
    }
}

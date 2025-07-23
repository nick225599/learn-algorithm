package org.nick.learn.leetcode.p34;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P34Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        if (n == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }

        // 1. 找到小于 target 的最大值的右下标
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int midIndex = (r + l) / 2;
            int midNum = nums[midIndex];
            if (target < midNum) {
                r = midIndex - 1;
            } else if (midNum < target) {
                if (l == midIndex && l + 1 == r) {
                    break;
                }
                l = midIndex;
            } else {
                r = midIndex - 1;
            }
        }
        int left = r;
        if (left < 0) {
            return new int[]{-1, -1};
        }

        // 2. 找到大于 target 的最小值的左下标
        l = 0;
        r = n - 1;
        while (l <= r) {
            int midIndex = (l + r) / 2;
            int midNum = nums[midIndex];
            if (target < midNum) {
                if (r == midIndex && l + 1 == r) {
                    break;
                }
                r = midIndex;
            } else if (midNum < target) {
                l = midIndex + 1;
            } else {
                l = midIndex + 1;
            }
        }
        int right = l;
        if (right > n - 1) {
            return new int[]{-1, -1};
        }

        if (left + 1 == right) {
            return new int[]{-1, -1};
        } else {
            return new int[]{left + 1, right - 1};
        }
    }
}

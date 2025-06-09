package org.nick.learn.leetcode.p128;

import java.util.Arrays;

public class P128Solution1 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }

        Arrays.sort(nums);

        int maxSum = Integer.MIN_VALUE;
        int sum = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                sum++;
            } else {
                maxSum = Math.max(maxSum, sum);
                sum = 1;
            }
        }
        return maxSum;
    }
}

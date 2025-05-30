package org.nick.learn.leetcode.p239;

public class Solution1 {

    // 暴力解法超时
    // 时间复杂度 O(n k)
    // 空间复杂度 O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }
}

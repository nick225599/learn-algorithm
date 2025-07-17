package org.nick.learn.leetcode.p53;

public class P53Solution2 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int maxSum = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                maxSum = Math.max(maxSum, nums[i]);
                continue;
            }
            for (int j = i; j < n; j++) {
                if (nums[j] <= 0) {
                    continue;
                }
                maxSum = Math.max(maxSum, this.sum(nums, i, j));
            }
        }
        return maxSum;
    }

    private int sum(int[] nums, int i, int j) {
        int sum = nums[i];
        for (int t = i + 1; t <= j; t++) {
            sum += nums[t];
        }
        return sum;
    }


}

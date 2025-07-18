package org.nick.learn.leetcode.p918;

public class P918Solution2 {

    // n^2 的解法也得做一个出来
    // 超出时间限制
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n << 1];
        System.arraycopy(nums, 0, newNums, 0, n);
        System.arraycopy(nums, 0, newNums, n, n);

        int finalMax = nums[0];
        for (int i = 0; i < n; i++) {
            int curMax = this.maxSubarraySumCircular(newNums, i, n);
            finalMax = Math.max(finalMax, curMax);
        }
        return finalMax;

    }

    private int maxSubarraySumCircular(int[] nums, int i, int n) {
        int pre = nums[i];
        int max = nums[i];
        for (int j = i + 1; j < i + n; j++) {
            pre = Math.max(nums[j], nums[j] + pre);
            max = Math.max(max, pre);
        }
        return max;
    }


}

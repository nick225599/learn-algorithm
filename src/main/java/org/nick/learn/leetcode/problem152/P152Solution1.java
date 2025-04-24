package org.nick.learn.leetcode.problem152;

/**
 * 力扣 152. 乘积最大子数组
 *
 * @see <a href="https://leetcode.cn/problems/maximum-product-subarray/description/">力扣 152. 乘积最大子数组</a>
 */
public class P152Solution1 {
    public int maxProduct(int[] nums) {
        int n= nums.length;

        int[][] dp = new int[n][2];
        dp[0][0] = nums[0]; // 第 0 位最大值
        dp[0][1] = nums[0]; // 第 1 位最小值

        int max = nums[0];

        for(int i = 1; i < n; i++){
            int i0 = dp[i - 1][0] * nums[i];
            int i1 = dp[i - 1][1] * nums[i];

            // 最大值
            int iMax = Math.max(i0, i1);
            dp[i][0] = Math.max(iMax, nums[i]);

            // 最小值
            int iMin = Math.min(i0, i1);
            dp[i][1] = Math.min(iMin, nums[i]);

            max = Math.max(max, dp[i][0]);
        }

        return max;
    }
}

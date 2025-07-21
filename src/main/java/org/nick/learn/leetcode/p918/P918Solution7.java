package org.nick.learn.leetcode.p918;

public class P918Solution7 {

    // 取反

    // 6ms, 击败 69%
    // 比 Solution5 还慢？？？ 不应该啊....
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        // [0, i] & [j, n - 1] 的最大子数组和（i < j） = sum[0, n - 1] - [i, j] 的最小子数组和
        int pre1, max1, pre2, min2, sum;
        pre1 = max1 = pre2 = min2 = sum = nums[0];
        for (int i = 1; i < n; i++) {
            pre1 = Math.max(nums[i], nums[i] + pre1);
            max1 = Math.max(max1, pre1);

            pre2 = Math.min(nums[i], nums[i] + pre2);
            min2 = Math.min(min2, pre2);

            sum += nums[i];
        }
        return max1 < 0 ? max1 : Math.max(max1, sum - min2);
    }


}

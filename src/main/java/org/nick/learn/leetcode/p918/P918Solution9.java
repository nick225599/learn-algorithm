package org.nick.learn.leetcode.p918;

public class P918Solution9 {

    // 跟 Solution7 一样啊，凭啥这个速度更快？
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int ans = kndane(nums, false);      // 假设不跨环值最大
        if (ans < 0) {       // 全为负数的情况
            return ans;
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        int minAns = kndane(nums, true);
        return Math.max(ans, total - minAns);
    }

    int kndane(int[] nums, boolean isMin) {
        int res = isMin ? -nums[0] : nums[0];
        int total = res;
        for (int i = 1; i < nums.length; i++) {
            int num = isMin ? -nums[i] : nums[i];
            total = Math.max(total + num, num);
            res = Math.max(res, total);
        }
        return isMin ? -res : res;
    }
}

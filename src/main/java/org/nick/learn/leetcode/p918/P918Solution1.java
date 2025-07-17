package org.nick.learn.leetcode.p918;

public class P918Solution1 {

    //TODO nick 20250717 看了下题，O(n) 的平方？
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int pre = nums[0];
        int max = nums[0];
        for (int i = 0; i < (n << 1); i++) {
            int cur = nums[i % n];
            pre = Math.max(pre, pre + cur);
            max = Math.max(pre, max);
        }
        return max;

        // 没想好怎么做，但隐隐觉得 O(n) 就行

    }


}

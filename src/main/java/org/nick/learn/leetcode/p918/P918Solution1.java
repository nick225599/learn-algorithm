package org.nick.learn.leetcode.p918;

public class P918Solution1 {

    // 1ms 击败100%
    //TODO nick 把这个 dp 状态变化方程捋一捋
    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;
        int[] newNums = new int[n<<1];
        System.arraycopy(nums, 0, newNums, 0, n);
        System.arraycopy(nums, 0, newNums, n, n);
        return this.maxSubArray(newNums);

    }

    // 看了下官方题解进行进一步优化
    // 1ms 击败 100%
    // 这还有个专名的算法名： Kadane 算法，可惜我出生晚了，不然我就有机会让这个算法叫 NICK SUN 算法
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int pre = nums[0];
        int max = nums[0];
        for(int i = 1; i < n; i++){
            pre = Math.max(nums[i], nums[i] + pre);
            max = Math.max(max, pre);
        }

        return max;
    }



}

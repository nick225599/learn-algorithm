package org.nick.learn.leetcode.p53;

public class P53Solution5 {

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

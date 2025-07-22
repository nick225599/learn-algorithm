package org.nick.learn.leetcode.p918;

public class P918Solution10 {
    public int maxSubarraySumCircular(int[] nums) {
        // 非环形数组最大值
        int Sub = SubarraySum(nums);
        int sum = 0;
        int len = nums.length;
        int[] resvernums = new int[nums.length];
        // 统计数组总值，生成相反数数组
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            resvernums[i] = -nums[i];
        }
        // 查找数组中最小的子数组和
        int min = -SubarraySum(resvernums);
        // Sub 非环形子数组最大和， sum-min 环形数组去掉中间最小值后的值
        // 现判断数组是否全负，全负 -> Sub，非全负 -> max(Sub,sum-min)
        return sum == min ? Sub : Math.max(sum - min, Sub);
    }

    private int SubarraySum(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}

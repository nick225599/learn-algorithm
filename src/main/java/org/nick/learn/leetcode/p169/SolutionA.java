package org.nick.learn.leetcode.p169;

import java.util.Arrays;

public class SolutionA {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
        //TODO sunchuansheng Boyer-Moore投票算法 算法
    }
}

package org.nick.learn.leetcode.p169;

import java.util.Arrays;

public class P169Solution1 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
}

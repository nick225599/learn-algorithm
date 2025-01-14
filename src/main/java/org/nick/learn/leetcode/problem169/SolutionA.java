package org.nick.learn.leetcode.problem169;

import java.util.Arrays;

public class SolutionA {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
        //TODO sunchuansheng 怎么实现堆排序？
        //TODO sunchuansheng 随机法(2次尝试) + 分治法
        //TODO sunchuansheng Boyer-Moore投票算法 算法
    }
}

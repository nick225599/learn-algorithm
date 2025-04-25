package org.nick.learn.leetcode.p2974;

import java.util.Arrays;

/**
 * 第一版，但是内存浪费了，其实可以原地出组装结果
 */
public class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                arr[i + 1] = nums[i];
            } else {
                arr[i - 1] = nums[i];
            }
        }
        return arr;
    }
}
package org.nick.learn.leetcode.problems2974;

import java.util.Arrays;

/**
 * 第 2 版，参考别的题解，原地组装结果
 */
public class Solution2 {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
//        Arrays.parallelSort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 2, 3};
        System.out.println(Arrays.toString(new Solution2().numberGame(nums)));
    }
}
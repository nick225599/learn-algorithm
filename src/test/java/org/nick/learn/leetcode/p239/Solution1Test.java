package org.nick.learn.leetcode.p239;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution1Test {
    Solution1 solution = new Solution1();


    @Test
    public void test1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        assertEquals("[3, 3, 5, 5, 6, 7]", Arrays.toString(result));
    }

}
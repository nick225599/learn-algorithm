package org.nick.learn.leetcode.problem239;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution8Test {

    Solution8 solution = new Solution8();

    @Test
    public void test() {
        int[] nums = new int[]{7, 2, 4};
        int k = 2;
        assertEquals("[7, 4]", Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }

}
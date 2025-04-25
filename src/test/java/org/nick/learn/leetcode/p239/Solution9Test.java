package org.nick.learn.leetcode.p239;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution9Test {

    Solution9 solution = new Solution9();

    @Test
    public void test() {
        int[] nums = new int[]{7, 2, 4};
        int k = 2;
        assertEquals("[7, 4]", Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }
}
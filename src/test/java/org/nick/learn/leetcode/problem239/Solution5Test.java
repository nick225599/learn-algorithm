package org.nick.learn.leetcode.problem239;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution5Test {

    Solution5 solution = new Solution5();

    @Test
    public void test1(){
        int[] nums = {1, -1};
        int k = 1;
        assertEquals("[1, -1]", Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }

}
package org.nick.learn.leetcode.problem239;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution3Test {
    Solution3 solution = new Solution3();

    @Test
    public void test(){
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        assertEquals("[3, 3, 5, 5, 6, 7]", Arrays.toString(result));
    }

}
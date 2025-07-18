package org.nick.learn.leetcode.p918;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P918Solution3Test {

    P918Solution3 solution = new P918Solution3();

    @Test
    void maxSubarraySumCircular() {
        int[] nums = new int[]{5, -3, 5};
        int ans = solution.maxSubarraySumCircular(nums);
        assertEquals(10, ans);
    }

    @Test
    void maxSubarraySumCircular2() {
        int[] nums = new int[]{1, -2, 3, -2};
        int ans = solution.maxSubarraySumCircular(nums);
        assertEquals(3, ans);
    }
}
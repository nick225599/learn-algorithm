package org.nick.learn.leetcode.p918;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P918Solution8Test {


    P918Solution8 solution = new P918Solution8();

    @Test
    void maxSubarraySumCircular() {
        int max = solution.maxSubarraySumCircular(new int[]{5, -3, 5});
        assertEquals(10, max);
    }

    @Test
    void maxSubarraySumCircular2() {
        int max = solution.maxSubarraySumCircular(new int[]{-3, -2, -3});
        assertEquals(-2, max);
    }


    @Test
    void maxSubarraySumCircular3() {
        int max = solution.maxSubarraySumCircular(new int[]{3,-1,2,-1});
        assertEquals(4, max);
    }
}
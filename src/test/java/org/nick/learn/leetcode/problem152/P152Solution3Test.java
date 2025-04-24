package org.nick.learn.leetcode.problem152;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P152Solution3Test {
    P152Solution3 solution = new P152Solution3();

    @Test
    void maxProduct1() {
        int[] nums = new int[]{-2, 3, -4};
        assertEquals(24, solution.maxProduct(nums));
    }

    @Test
    void maxProduct2() {
        int[] nums = new int[]{3,-1,4};
        assertEquals(4, solution.maxProduct(nums));
    }
}
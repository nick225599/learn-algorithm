package org.nick.learn.leetcode.p152;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P152Solution1Test {

    P152Solution1 solution = new P152Solution1();

    @Test
    void maxProduct1() {
        int[] nums = new int[]{2,3,-2,4};
        assertEquals(6, solution.maxProduct(nums));
    }
    @Test
    void maxProduct2() {
        int[] nums = new int[]{-2,3,-4};
        assertEquals(24, solution.maxProduct(nums));
    }
}
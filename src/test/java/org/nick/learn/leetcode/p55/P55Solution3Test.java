package org.nick.learn.leetcode.p55;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class P55Solution3Test {
    private P55Solution3 solution = new P55Solution3();

    @Test
    void canJump() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        assertTrue(solution.canJump(nums));
    }

    @Test
    void canJump2() {
        int[] nums = new int[]{2,5,0,0};
        assertTrue(solution.canJump(nums));
    }
}
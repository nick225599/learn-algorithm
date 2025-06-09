package org.nick.learn.leetcode.p128;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P128Solution1Test {
    P128Solution1 solution = new P128Solution1();


    @Test
    void longestConsecutive() {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        assertEquals(9, solution.longestConsecutive(nums));
    }

    @Test
    void longestConsecutive2() {
        int[] nums = new int[]{1,0,1,2};
        assertEquals(3, solution.longestConsecutive(nums));
    }
}
package org.nick.learn.leetcode.p209;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P209Solution1Test {
    P209Solution1 solution = new P209Solution1();

    @Test
    void minSubArrayLen() {
        assertEquals(2, solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
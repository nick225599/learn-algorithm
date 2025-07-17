package org.nick.learn.leetcode.p53;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P53Solution6Test {
    P53Solution6 solution = new P53Solution6();
    @Test
    void maxSubArray() {
        int a = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6, a);
    }
}
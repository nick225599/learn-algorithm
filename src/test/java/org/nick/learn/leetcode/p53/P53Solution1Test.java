package org.nick.learn.leetcode.p53;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P53Solution1Test {

    P53Solution1 solution = new P53Solution1();

    @Test
    void maxSubArray() {
        int a = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6, a);
    }
}
package org.nick.learn.leetcode.p53;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P53Solution6Test {
    P53Solution6 solution = new P53Solution6();

    @Test
    void maxSubArray() {
        int a = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6, a);
    }

    @Test
    void maxSubArra1() {
        int a = solution.maxSubArray(new int[]{1, 2});
        assertEquals(3, a);
    }

    @Test
    void maxSubArra2() {
        int a = solution.maxSubArray(new int[]{1, -1});
        assertEquals(1, a);
    }

    @Test
    void maxSubArra3() {
        int a = solution.maxSubArray(new int[]{-1, 1});
        assertEquals(1, a);
    }

    @Test
    void maxSubArra4() {
        int a = solution.maxSubArray(new int[]{9, -6, 4});
        assertEquals(9, a);
    }

    @Test
    void maxSubArra5() {
        int a = solution.maxSubArray(new int[]{-9, 6, -4});
        assertEquals(6, a);
    }
}
package org.nick.learn.leetcode.p69;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution2Test {
    Solution2 solution = new Solution2();

    @Test
    void mySqrt1() {
        assertEquals(2, solution.mySqrt(4));
    }


    @Test
    void mySqrt() {
        assertEquals(1, solution.mySqrt(1));
        assertEquals(2, solution.mySqrt(4));
        assertEquals(3, solution.mySqrt(9));
        assertEquals(4, solution.mySqrt(16));
        assertEquals(5, solution.mySqrt(25));
        assertEquals(6, solution.mySqrt(36));
        assertEquals(7, solution.mySqrt(49));
        assertEquals(8, solution.mySqrt(64));
        assertEquals(9, solution.mySqrt(81));
        assertEquals(10, solution.mySqrt(100));
        assertEquals(11, solution.mySqrt(121));
        assertEquals(12, solution.mySqrt(144));
        assertEquals(13, solution.mySqrt(169));

    }

    @Test
    void mySqrt2() {
        System.out.println("x = 8, x 的平方根: ");
        System.out.println(solution.mySqrt(8));
    }
}
package org.nick.learn.leetcode.p137;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P137Solution3Test {
    P137Solution3 solution = new P137Solution3();

    @Test
    void singleNumber1() {
        int num = solution.singleNumber(new int[]{2, 2, 3, 2});
        assertEquals(3, num);
    }

    @Test
    void singleNumber() {
        int num = solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99});
        assertEquals(99, num);
    }
}
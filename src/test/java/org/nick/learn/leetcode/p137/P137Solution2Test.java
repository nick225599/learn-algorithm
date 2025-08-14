package org.nick.learn.leetcode.p137;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P137Solution2Test {
    P137Solution2 solution = new P137Solution2();

    @Test
    void singleNumber1() {
        int num = solution.singleNumber(new int[]{2,2,3,2});
        assertEquals(3, num);
    }

    @Test
    void singleNumber() {
        int num = solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99});
        assertEquals(99, num);
    }
}
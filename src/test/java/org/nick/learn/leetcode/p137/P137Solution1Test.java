package org.nick.learn.leetcode.p137;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P137Solution1Test {
    P137Solution1 solution = new P137Solution1();

    @Test
    void singleNumber() {
        int num = solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99});
        assertEquals(99, num);
    }
}
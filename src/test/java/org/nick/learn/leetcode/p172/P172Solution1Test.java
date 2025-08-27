package org.nick.learn.leetcode.p172;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P172Solution1Test {
    P172Solution1 solution = new P172Solution1();

    @Test
    void trailingZeroes() {
       assertEquals(1, solution.trailingZeroes(5));
    }

    @Test
    void trailingZeroes2() {
        assertEquals(2, solution.trailingZeroes(13));
    }
}
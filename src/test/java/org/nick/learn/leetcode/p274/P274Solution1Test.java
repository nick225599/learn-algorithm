package org.nick.learn.leetcode.p274;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P274Solution1Test {
    P274Solution1 solution = new P274Solution1();

    @Test
    void hIndex() {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        assertEquals(3, solution.hIndex(citations));
    }
}
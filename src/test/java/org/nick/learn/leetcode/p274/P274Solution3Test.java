package org.nick.learn.leetcode.p274;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P274Solution3Test {
    P274Solution3 solution = new P274Solution3();

    @Test
    void hIndex() {
        int[] citations = new int[]{0, 0, 2};
        assertEquals(1, solution.hIndex(citations));
    }
}
package org.nick.learn.leetcode.p274;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P274Solution2Test {
    P274Solution2 solution = new P274Solution2();

    @Test
    void hIndex() {
        int[] citations = new int[]{0, 0, 2};
        assertEquals(1, solution.hIndex(citations));
    }
}
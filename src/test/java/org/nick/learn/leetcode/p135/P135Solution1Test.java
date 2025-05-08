package org.nick.learn.leetcode.p135;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P135Solution1Test {

    P135Solution1 solution = new P135Solution1();

    @Test
    void candy() {
        int[] ratings = new int[]{1, 2, 2};
        assertEquals(4, solution.candy(ratings));
    }
}
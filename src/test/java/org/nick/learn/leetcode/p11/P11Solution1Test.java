package org.nick.learn.leetcode.p11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P11Solution1Test {
    P11Solution1 solution = new P11Solution1();

    @Test
    void maxArea() {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, solution.maxArea(arr));
    }
}
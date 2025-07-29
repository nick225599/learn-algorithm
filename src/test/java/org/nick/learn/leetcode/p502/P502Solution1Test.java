package org.nick.learn.leetcode.p502;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P502Solution1Test {
    P502Solution1 solution = new P502Solution1();

    @Test
    void findMaximizedCapital() {
        int maximizedCapital = solution.findMaximizedCapital(
                2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
        assertEquals(4, maximizedCapital);
    }
}
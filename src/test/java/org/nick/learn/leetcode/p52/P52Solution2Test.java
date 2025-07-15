package org.nick.learn.leetcode.p52;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P52Solution2Test {
    P52Solution2 solution = new P52Solution2();

    @Test
    void totalNQueens() {
        assertEquals(2, solution.totalNQueens(4));
    }
}
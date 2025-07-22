package org.nick.learn.leetcode.p33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P33Solution2Test {
    P33Solution2 solution = new P33Solution2();

    @Test
    void search() {
        assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    void search2() {
        assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    void search3() {
        assertEquals(0, solution.search(new int[]{1}, 1));
    }

    @Test
    void search4() {
        assertEquals(-1, solution.search(new int[]{1, 3}, 0));
    }
}
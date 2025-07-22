package org.nick.learn.leetcode.p33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P33Solution4Test {

    P33Solution4 solution = new P33Solution4();

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

    @Test
    void search5() {
        assertEquals(1, solution.search(new int[]{3, 1}, 1));
    }

    @Test
    void search6() {
        assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }
}
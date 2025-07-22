package org.nick.learn.leetcode.p33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P33Solution1Test {

    P33Solution1 solution = new P33Solution1();

    @Test
    void search() {
        assertEquals(1, solution.search(new int[]{3, 1}, 1));
    }
}
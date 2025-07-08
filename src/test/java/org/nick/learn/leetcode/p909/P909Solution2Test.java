package org.nick.learn.leetcode.p909;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P909Solution2Test {
    P909Solution2 solution = new P909Solution2();


    @Test
    void snakesAndLadders() {
        int[][] board = new int[][]{
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, 35, -1, -1, 13, -1},
                new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, 15, -1, -1, -1, -1}
        };
        assertEquals(4, solution.snakesAndLadders(board));
    }

}
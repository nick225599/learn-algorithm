package org.nick.learn.leetcode.p909;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P909Solution1Test {
    P909Solution1 solution = new P909Solution1();


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
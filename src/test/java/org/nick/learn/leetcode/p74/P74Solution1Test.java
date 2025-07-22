package org.nick.learn.leetcode.p74;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class P74Solution1Test {

    P74Solution1 solution = new P74Solution1();

    @Test
    void searchMatrix() {
        assertTrue(solution.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 3));
    }

}
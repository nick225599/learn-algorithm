package org.nick.learn.leetcode.p74;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @Test
    void searchMatrix2() {
        assertFalse(solution.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 13));
    }

    @Test
    void testSearchMatrix() {
        assertFalse(solution.searchMatrix(new int[][]{
                {1, 3}
        }, 2));
    }
}
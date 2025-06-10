package org.nick.learn.leetcode.p56;

import org.junit.jupiter.api.Test;

import static org.nick.learn.algorithm.utils.ArrayUtils.printMatrix;

class P56Solution5Test {
    P56Solution5 solution = new P56Solution5();

    @Test
    void merge() {
        int[][] intervals = new int[][]{
                {2, 3}, {4, 6}, {5, 7}, {3, 4}
        };
        printMatrix(solution.merge(intervals));
    }
}
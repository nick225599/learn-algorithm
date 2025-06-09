package org.nick.learn.leetcode.p56;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.nick.learn.algorithm.utils.ArrayUtils.printMatrix;

class P56Solution2Test {

    P56Solution2 solution = new  P56Solution2();

    @Test
    void merge() {
        int[][] intervals = new int[][]{
                {2, 3}, {4, 6}, {5, 7}, {3, 4}
        };
        printMatrix(solution.merge(intervals));
    }
}
package org.nick.learn.leetcode.p56;

import org.junit.jupiter.api.Test;

class P56Solution1Test {
    P56Solution1 solution = new P56Solution1();

    @Test
    void merge() {
        int[][] intervals = new int[][]{
                {2, 3},
                {4, 6},
                {5, 7},
                {3, 4}
        };
        solution.merge(intervals);
    }
}
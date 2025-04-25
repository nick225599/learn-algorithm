package org.nick.learn.leetcode.p64;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {

    Solution1 solution = new Solution1();

    @Test
    void minPathSum() {
        int[][] gird = new int[][]{
                {1,2,3},
                {4,5,6}
        };
        assertEquals(12, solution.minPathSum(gird));
    }
}
package org.nick.learn.leetcode.problem427;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void construct() {
        Solution solution = new Solution();
        int[][] grid;
        Node root;

        grid = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
        root = solution.construct(grid);
        org.junit.jupiter.api.Assertions.assertEquals("[0,1,1,0]", root.toString());

        grid = new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };

        root = solution.construct(grid);
        org.junit.jupiter.api.Assertions.assertEquals("[1,[0,0,1,1],1,0]", root.toString());
    }
}
package org.nick.learn.leetcode.p200;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution1Test {

    Solution4 solution = new Solution4();
//    Solution2 solution = new Solution2();

    @Test
    void numIslands() {
        char[][] gird = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, solution.numIslands(gird));
    }

    @Test
    void numIslands1() {
        // [[1,1,1],[0,1,0],[1,1,1]]
        char[][] gird = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        assertEquals(1, solution.numIslands(gird));
    }

    @Test
    void numIslands2() {
        char[][] gird = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, solution.numIslands(gird));

    }
}
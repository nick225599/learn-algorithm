package org.nick.learn.leetcode.problem200;

public class Solution2 {

    /**
     * 广度优先
     */
    public int numIslands(char[][] grid) {
        int queueIdx = 0;
        int[][] queue = new int[grid.length * grid[0].length][2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    queue[queueIdx++] = new int[]{i,j};
                }
            }
        }
        int sum = 0;
        for (int[] ints : queue) {
            int x = ints[0];
            int y = ints[1];
            if (grid[x][y] == '1') {
                tagIsland(grid, x, y);
                sum++;
            }
        }
        return sum;
    }

    private void tagIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || grid[i][j] != '1') {
            return;
        }

        // 标记当前陆地
        grid[i][j] = 'x';

        // 标记上边陆地
        tagIsland(grid, i, j - 1);

        // 标记下边陆地
        tagIsland(grid, i, j + 1);

        // 标记左边陆地
        tagIsland(grid, i - 1, j);

        // 标记右边陆地
        tagIsland(grid, i + 1, j);
    }
}

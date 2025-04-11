package org.nick.learn.leetcode.problem200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    /**
     * 广度优先
     */
    public int numIslands(char[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = 'x';
                    bfs(grid, i, j);
                    sum++;
                }
            }
        }
        return sum;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        do{
            int[] xy = queue.poll();
            int x = xy[0]; int y = xy[1];
            int m, n;
            // 左
            m = x; n = y - 1;
            if(m >= 0 && m < grid.length && n >= 0 && n < grid[0].length && grid[m][n] == '1'){
                grid[m][n] = 'x';
                queue.add(new int[]{m, n});
            }

            // 右
            m = x; n = y + 1;
            if(m >= 0 && m < grid.length && n >= 0 && n < grid[0].length && grid[m][n] == '1'){
                grid[m][n] = 'x';
                queue.add(new int[]{m, n});
            }

            // 上
            m = x - 1; n = y;
            if(m >= 0 && m < grid.length && n >= 0 && n < grid[0].length && grid[m][n] == '1'){
                grid[m][n] = 'x';
                queue.add(new int[]{m, n});
            }

            // 下
            m = x + 1; n = y;
            if(m >= 0 && m < grid.length && n >= 0 && n < grid[0].length && grid[m][n] == '1'){
                grid[m][n] = 'x';
                queue.add(new int[]{m, n});
            }
        } while (!queue.isEmpty());

    }

}

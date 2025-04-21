package org.nick.learn.leetcode.problem64;

public class Solution2 {

    /**
     * AI 建议的优化版本
     *
     * 时间复杂度依旧是 O(nr * nc)
     * 空间复杂度依旧是 O(nr * nc)
     */
    public int minPathSum(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        int[][] dp = new int[nr][nc];
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (i == 0 && j == 0) {
                    // 第一个格子，没有左边元素，也没有上边元素
                    dp[i][j] = grid[i][j];

                } else if (i == 0) {
                    // 第 0 行，没有上面元素
                    dp[i][j] = grid[i][j] + dp[i][j - 1];

                } else if (j == 0) {
                    // 第 1 列，没有左边元素
                    dp[i][j] = grid[i][j] + dp[i - 1][j];

                } else {

                    // 其他格子，既有左边格子，也有右边格子
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nr - 1][nc - 1];
    }
}

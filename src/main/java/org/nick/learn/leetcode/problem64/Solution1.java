package org.nick.learn.leetcode.problem64;

public class Solution1 {
    public int minPathSum(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        int[][] dp = new int[nr][nc];
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j - 1 >= 0) {
                    dp[i][j] = dp[i][j - 1];
                }
                dp[i][j] += grid[i][j];
            }
        }

        return dp[nr - 1][nc - 1];
    }
}

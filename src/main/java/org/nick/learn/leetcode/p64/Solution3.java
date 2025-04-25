package org.nick.learn.leetcode.p64;

public class Solution3 {

    /**
     * 空间复杂度优化到 O(nc)
     *
     * 代码逻辑看着有点绕了就
     */
    public int minPathSum(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        int[] dp = new int[nc];
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (i == 0 && j == 0) {
                    // 第一个格子，没有左边元素，也没有上边元素
                    dp[j] = grid[i][j];

                } else if (i == 0) {
                    // 第 0 行，没有上面元素
                    dp[j] = grid[i][j] + dp[j - 1];

                } else if (j == 0) {
                    // 第 1 列，没有左边元素
                    dp[j] += grid[i][j];

                } else {

                    // 其他格子，既有左边格子，也有右边格子
                    dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
                }
            }
        }

        return dp[nc - 1];
    }
}

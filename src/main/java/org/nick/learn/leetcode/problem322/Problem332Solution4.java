package org.nick.learn.leetcode.problem322;

import java.util.Arrays;

/**
 * 力扣 322. 零钱兑换
 * @see <a href="https://leetcode.cn/problems/coin-change/description/">力扣 322. 零钱兑换</a>
 */
public class Problem332Solution4 {

    /**
     * 动态规划
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        long[] dp = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }
}

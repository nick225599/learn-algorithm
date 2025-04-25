package org.nick.learn.leetcode.p322;

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

        // nick 20250423 因为题目限制了 amount 范围：0 <= amount <= 10^4
        // 所以不用填充 Integer.Max_value ，不然第 29 行会越界，为了避免越界我用了 long[]
        // 而官方题解，用了 Arrays.fill(dp, amount + 1)， 官方题解更巧妙，
        // 另外 return dp[amount] > amount ? -1 也比我的 == Integer.MAX_VAL 可读性更强
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

package org.nick.learn.leetcode.problem322;

import java.util.Arrays;

/**
 * 力扣 322. 零钱兑换
 * @see <a href="https://leetcode.cn/problems/coin-change/description/">力扣 322. 零钱兑换</a>
 */
public class Problem332Solution5 {

    /**
     * 动态规划，官方题解
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/coin-change/solutions/132979/322-ling-qian-dui-huan-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

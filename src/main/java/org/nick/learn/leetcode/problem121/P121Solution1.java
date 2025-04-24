package org.nick.learn.leetcode.problem121;

/**
 * 力扣 121. 买卖股票的最佳时机
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/">力扣 121. 买卖股票的最佳时机</a>
 */
public class P121Solution1 {

    /**
     * 直观解法
     * O(n^2)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int income = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                income = Math.max(income, prices[j] - prices[i]);
            }
        }
        return income;
    }
}

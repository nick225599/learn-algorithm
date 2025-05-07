package org.nick.learn.leetcode.p122;

/**
 * 力扣 22. 买卖股票的最佳时机 II
 */
public class P122Solution3 {

    /**
     * 动态规划
     */
    public int maxProfit(int[] prices) {
        int hold = -prices[0];  // 持股
        int sell = 0;           // 抛售
        for (int i = 0; i < prices.length; i++) {
            int newHold = Math.max(hold, sell - prices[i]);
            int newSell = Math.max(sell, hold + prices[i]);
            hold = newHold;
            sell = newSell;
        }
        return sell;
    }
}

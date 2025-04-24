package org.nick.learn.leetcode.problem121;

/**
 * 力扣 121. 买卖股票的最佳时机
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/">力扣 121. 买卖股票的最佳时机</a>
 */
public class P121Solution2 {

    /**
     * 一次遍历
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int maxIncome = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price); // 历史最低价
            int income = price - minPrice; // 从历史最低价买入，今天卖出的收益
            maxIncome = Math.max(maxIncome, income); // 推算出最大收益
        }
        return maxIncome;
    }
}

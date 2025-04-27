package org.nick.learn.leetcode.p122;

/**
 * 力扣 22. 买卖股票的最佳时机 II
 */
public class P122Solution2 {

    /**
     * 优化代码，将其优化成标准的贪心算法
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) {
                sum += tmp;
            }
        }
        return sum;
    }
}

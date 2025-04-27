package org.nick.learn.leetcode.p122;

/**
 * 力扣 22. 买卖股票的最佳时机 II
 */
public class P122Solution1 {

    public int maxProfit(int[] prices) {
        // 当前持有股票的收益 = 前一天持有股票的收益 or 前一天不持有股票的收益 - 今天的股价
        int sum = 0;
        Integer in = null;
        Integer out = null;
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length) {
                if (prices[i + 1] > prices[i]) {
                    // 如果明天价格比今天高，且手头没股票，今天才要买入，否则等明天再判断要不要卖出
                    if (null == in) {
                        in = prices[i];
                    }
                } else {
                    // 如果明天价格比今天低，今天要卖出
                    out = prices[i];
                    if (null != in) {
                        sum += (out - in);
                        in = out = null;
                    }
                }
            } else {
                // 今天最后一个天了
                if (null != in) {
                    sum += (prices[i] - in);
                }
            }
        }


        return sum;
    }
}

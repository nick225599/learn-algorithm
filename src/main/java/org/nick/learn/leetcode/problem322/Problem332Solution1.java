package org.nick.learn.leetcode.problem322;

import java.util.Arrays;

public class Problem332Solution1 {

    private int minCount = -1;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        coinChange(coins, amount, 0, 0);
        return minCount;
    }

    private void coinChange(int[] coins, int amount, int sum, int count) {
        if (sum > amount || (minCount != -1 && count > minCount)) {
            return;
        }
        if (sum == amount) {
            if (minCount == -1) {
                minCount = count;
            } else {
                minCount = Math.min(count, minCount);
            }
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            if (sum <= amount - coins[i]) {
                coinChange(coins, amount, sum + coins[i], count + 1);
            }
        }
    }

}

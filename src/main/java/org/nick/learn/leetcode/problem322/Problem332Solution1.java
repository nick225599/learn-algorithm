package org.nick.learn.leetcode.problem322;

import java.util.Arrays;

public class Problem332Solution1 {

    private int minCount = -1;
    private int callCount = 0;
    private long[] cache;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        // 初始化
        cache = new long[amount + 1];
        Arrays.fill(cache, -2);

        coinChange(coins, amount, 0, 0, coins.length - 1);
        System.out.println("callCount: " + callCount);
        return minCount;
    }

    private void coinChange(int[] coins, int amount, int sum, int count, int start) {
        if (sum == amount) {
            minCount = count;
            return;
        }

        if (cache[sum] != -2 && cache[sum] <= count) {
            return;
        }
        cache[sum] = count;

        for (int i = start; i >= 0; i--) {
            if (sum <= amount - coins[i] && (minCount == -1 || minCount > count)) {
                coinChange(coins, amount, sum + coins[i], count + 1, i);
                callCount++;
            }
        }
    }

}

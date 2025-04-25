package org.nick.learn.leetcode.p322;

import java.util.Arrays;

public class Problem332Solution2 {

    private int minCount = -1;
    private long[] cache;
    private int callCount = 0;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        // 初始化缓存
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

        // 剪枝：如果当前硬币数量已经超过已知最小值，直接返回
        if (minCount != -1 && count >= minCount) {
            return;
        }

        // 缓存剪枝
        if (cache[sum] != -2 && cache[sum] <= count) {
            return;
        }
        cache[sum] = count;

        callCount++;

        // 从大到小尝试硬币
        for (int i = start; i >= 0; i--) {
            if (sum <= amount - coins[i] && (minCount == -1 || minCount > count)) {
                coinChange(coins, amount, sum + coins[i], count + 1, i);
            }
        }
    }

}

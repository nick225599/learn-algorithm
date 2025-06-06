package org.nick.learn.leetcode.p322;

public class Problem332Solution3 {
    private int callCount = 0;

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int result =  coinChange(coins, amount, new int[amount]);
        System.out.println("callCount: " + callCount);

        return result;
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        callCount++;
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }


}

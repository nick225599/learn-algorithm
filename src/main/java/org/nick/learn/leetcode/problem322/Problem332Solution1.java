package org.nick.learn.leetcode.problem322;

public class Problem332Solution1 {

    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, 0, 0, 0);
    }


    public int coinChange(int[] coins, int amount, int i, int sum, int count) {
        if(sum == amount){
            return count;
        }

        // 不放入
        int notPut = count;
        if (i < coins.length) {
            notPut = coinChange(coins, amount, i + 1, sum, count);
        }

        // 放入
        int put = count;
        if (sum + coins[i] <= amount) {
            put = coinChange(coins, amount, i, sum + coins[i], count + 1);
        }

        //TODO nick 不会写回溯，摊牌了
        return -1;
    }


}

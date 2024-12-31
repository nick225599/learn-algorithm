package org.nick.learn.algorithm.dynamicprogramming;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Knapsack04 {

    /**
     * @param weight 物品重量
     * @param n      物品个数
     * @param w      背包可承载重量
     */
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }

        // 动态规划状态转移
        for (int i = 1; i < n; ++i) {

            // 不把第i个物品放入背包
            for (int j = 0; j <= w; ++j) {
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }

            // 把第i个物品放入背包
            for (int j = 0; j <= w - weight[i]; ++j) {
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }

        // 输出结果
        for (int i = w; i >= 0; --i) {
            if (states[n - 1][i]) return i;
        }

        return 0;
    }

    public static void main(String[] args) {
        Knapsack04 knapsack = new Knapsack04();
        int[] weights = {2, 2, 4, 6, 3};
        int n = weights.length;
        int w = 9;
        int maxWeight = knapsack.knapsack(weights, n, w);
        log.info("Max Weight in Knapsack: " + maxWeight);
    }
}

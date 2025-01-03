package org.nick.learn.algorithm.dynamicprogramming;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.utils.ArrayUtils;

/**
 * 将课程里的动态规划代码跟自己实现的比一比呢，
 * 王争老师的动态规划第一层是手算的，以便循环里的代码简单一点
 */
@Slf4j
public class Knapsack06 {

    /**
     * @param weight 物品重量，
     * @param n      物品个数，
     * @param w      背包可承载重量
     */
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第i个物品放入背包
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) {//把第i个物品放入背包
                if (states[i - 1][j] == true) states[i][j + weight[i]] = true;
            }
            log.info("i: {}", i);
            log.info("weight[i]: {}", weight[i]);
            log.info("states: ");
            ArrayUtils.print(states);
            System.out.println();
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n - 1][i] == true) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] weight = {2, 2, 4, 6, 3}; // 物品重量
        int w = 9; // 背包承受的最大重量
        Knapsack05 k = new Knapsack05();
        int maxW = k.knapsack(weight, w);
        log.info("maxW: {}", maxW);
    }
}

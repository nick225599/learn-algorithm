package org.nick.learn.algorithm.dynamicprogramming;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.utils.ArrayUtils;

/**
 * 自己理解动态规划来求解
 */
@Slf4j
public class Knapsack05 {

    /**
     * 0-1 背包问题，有一个最大承重量为 n 的背包，有一批物品，重量为 weights
     * 物品不能拆零分装，只能选择装入背包，或者不装入背包，
     * 求这批物品装入背包时，能组合出的最大被装入量是多少
     * <p>
     * 比如，有 3 个物品，重量分别为 [2, 4, 6, 8]
     * 背包最大承重量为 11，那么最大能被装入的重量为 10（6 + 4 或 8 + 2）
     *
     * @param weights 可以拿来装包的物品的重量
     * @param n       背包最大承重（含）
     * @return 背包能装得下的最大重量
     */
    public static int knapsack(int[] weights, int n) {

        int[][] status = new int[weights.length][1 + n];

        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            for (int j = 0; j < n + 1; j++) {

                // 放入
                if (0 == i) {
                    if (w <= n) {
                        status[0][w] = 1; // 可放入
                    } else {
                        // 不可放入，不需要做啥
                    }
                } else {
                    // 上一层的重量
                    int curW = 1 == status[i - 1][j] ? j : 0;
                    int newW = curW + w;
                    if (newW <= n) { // 可放入
                        status[i][newW] = 1;
                    } else {
                        // 不可放入，不需要做啥
                    }
                }

                // 不放入
                if (0 == i) {
                    status[i][0] = 1;
                } else {
                    //scs20240501
                    // 其实可以写成王争老师那样，减少不必要的 if 判断
                    // 不对，其实没有对错，取决于有效状态的多寡，
                    // 但是就这个 01 背包问题而言，肯定是反过来写合适
                    // if(status[i - 1][j] == 1){
                    //    status[i][j] = 1;
                    // }
                    if (1 != status[i][j]) {
                        status[i][j] = status[i - 1][j];
                    }
                }
            }
            log.info("i: {}", i);
            log.info("weight[i]: {}", weights[i]);
            log.info("status: ");
            ArrayUtils.printMatrix(status);
            System.out.println();
        }

        for (int j = n; j >= 0; j--) {
            for (int i = 0; i < weights.length; i++) {
                if (1 == status[i][j]) {
                    return j;
                }
            }
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

package org.nick.learn.algorithm.dynamicprogramming;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.utils.ArrayUtils;

@Slf4j
public class Knapsack03 {
    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量
    private int[][] memo; // 记忆化数组

    public Knapsack03() {
        memo = new int[n][w + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
    }

    public void f(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }
        if (memo[i][cw] != -1) { // 如果已经计算过，直接跳过
            return;
        }

        f(i + 1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // 选择装第i个物品
        }

        memo[i][cw] = maxW; // 存储当前状态的结果
    }

    public static void main(String[] args) {
        Knapsack03 knapsack = new Knapsack03();
        knapsack.f(0, 0);
        log.info("Max Weight in Knapsack: " + knapsack.maxW);
        log.info("memo: ");
        ArrayUtils.print(knapsack.memo);
    }
}




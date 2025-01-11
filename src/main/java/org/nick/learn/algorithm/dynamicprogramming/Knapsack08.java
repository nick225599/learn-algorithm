package org.nick.learn.algorithm.dynamicprogramming;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 一维数组，为啥王争不需要处理当前为 false 的情况？
 */
@Slf4j
public class Knapsack08 {

    /**
     * @param items 物品重量，
     * @param n     物品数量
     * @param w     背包可承载重量
     */
    public int knapsack(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1]; // 默认值false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= w) {
            states[items[0]] = true;
        }
        log.info("i: {}", 0);
        log.info("status: ");
        System.out.println(Arrays.toString(states));
        System.out.println();
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = w - items[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j] == true) states[j + items[i]] = true;

                // int j = w - items[i]; j >= 0; --j
                // j 表示 将放入第 i 个物品而未放入时，包里已有物品的重量
                // if(states[j] == true) 表示
                // 仅当这个重量可达的时候
                // states[j + items[i]] = true; 表示
                // 可达的时候才进行标记可达

                // 一个往前遍历 --j 一个往后标记 states[j + ?] = true
                // 保证了永远不会错误地标记
            }
            log.info("i: {}", i);
            log.info("status: ");
            System.out.println(Arrays.toString(states));
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i] == true) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] weight = {3,1, 4, 6, 3}; // 物品重量
        int w = 9; // 背包承受的最大重量
        Knapsack08 k = new Knapsack08();
        int maxW = k.knapsack(weight, weight.length, w);
        log.info("maxW: {}", maxW);
    }
}

package org.nick.learn.algorithm.dynamicprogramming;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 0-1 背包问题（0-1 Knapsack Problem）是一个经典的组合优化问题，它得名于一个旅行者在决定要带哪些物品上路时所面临的抉择。这个问题的名称来源于你只能选择将整个物品放入背包中（1），或者完全不选这个物品（0），不能选择装入部分物品。
 * <p>
 * <strong>问题描述</strong>
 * 给定一组物品，每种物品都有自己的重量和价值，在限定的总重量内，如何选择物品使得物品的总价值最大。每个物品只能使用一次。
 * <p>
 * 具体来说：
 * <p>
 * 有 n 个物品，第 i 个物品的重量为 w[i]，价值为 v[i]。
 * 有一个能承受的最大重量为 W 的背包。
 * 目标是选择一些物品放入背包，使得这些物品的总重量不超过 W，且总价值尽可能大。
 */
@Slf4j
@Getter
public class Knapsack01 {

    // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
    private int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    /**
     * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，
     * 在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
     *
     * @param cw 背包内物品的总重
     * @param i
     */
    public void f(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }

        // 选择不装第i个物品
        f(i + 1, cw);

        // 选择装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]);
        }
    }

    public static void main(String[] args) {
        Knapsack01 instance = new Knapsack01();
        instance.f(0, 0);
    }
}

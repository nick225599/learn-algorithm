package org.nick.learn.algorithm.dynamicprogramming;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

/**
 * 一维数组
 */
@Slf4j
public class Knapsack07 {

    /**
     * @param items 物品重量，
     * @param w      背包可承载重量
     */
    public int knapsack(int[] items, int w) {
        int n = items.length;
        boolean[] status = new boolean[w + 1];

        status[0] = true;
        int tempWeight = items[0];
        if (tempWeight <= w) {
            status[tempWeight] = true;
        }
        log.info("i: {}", 0);
        log.info("status: ");
        System.out.println(Arrays.toString(status));
        System.out.println();

        for(int i = 1; i < n; i++){
            tempWeight = items[i];
            for(int j = w; j >= 0; j--){
                // 放入
                if(status[j]){
                    if(j + tempWeight <= w){
                        status[j + tempWeight] = true;
                    }else{
                        status[tempWeight] = true;
                    }
                }

                // 不放入
                // 不用动
            }
            log.info("i: {}",i);
            log.info("status: ");
            System.out.println(Arrays.toString(status));
            System.out.println();
        }

        for(int i = w; i >= 0; --i){
            if(status[i]){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] weight = {3, 1, 4, 6, 3}; // 物品重量
        int w = 9; // 背包承受的最大重量
        Knapsack07 k = new Knapsack07();
        int maxW = k.knapsack(weight, w);
        log.info("maxW: {}", maxW);
    }
}

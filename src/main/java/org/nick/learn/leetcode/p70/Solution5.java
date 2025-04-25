package org.nick.learn.leetcode.p70;

import lombok.Getter;

@Getter
public class Solution5 {

    // 记忆化递归标准解法，线程安全
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public int climbStairs(int n) {
        int[] cache  = new int[n + 1];
        return climbStairsHelper(n, cache);
    }

    private int climbStairsHelper(int n, int[] cache) {
        if(n == 1 || n == 2){
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        int result = climbStairsHelper(n - 1, cache)
                + climbStairsHelper(n - 2, cache);
        cache[n] = result;
        return result;
    }
}

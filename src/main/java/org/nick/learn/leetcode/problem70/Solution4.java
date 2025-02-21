package org.nick.learn.leetcode.problem70;

import lombok.Getter;

@Getter
public class Solution4 {
    int[] cache;
    int cacheUsedTimes = 0;
    int recursionDepth = 0;

    // 用缓存优化递归？
    public int climbStairs(int n) {
        recursionDepth++;
        if (null == cache) {
            cache = new int[n + 1];
        }
        cache[1] = 1;
        cache[2] = 2;
        if (cache[n] != 0) {
            cacheUsedTimes++;
            return cache[n];
        }

        // 先于 n-1 计算，能减少栈溢出的风险（虽然我觉得意义不大）
        int n2 = 0;
        if (n - 2 > 0) {
            n2 = climbStairs(n - 2);
        }

        int n1 = 0;
        if (n - 1 > 0) {
            n1 = climbStairs(n - 1);
        }

        return n1 + n2;
    }
}

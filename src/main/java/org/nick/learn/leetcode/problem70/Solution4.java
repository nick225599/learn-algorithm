package org.nick.learn.leetcode.problem70;

import lombok.Getter;

@Getter
public class Solution4 {
    int[] cache; // 线程不安全

    // 用缓存优化递归？
    public int climbStairs(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        if (null == cache || cache.length < n + 1) {
            cache = new int[n + 1]; // 多次调用时，复用缓存。而不是为每次调用，重新创建一份缓存
            // 但如果 N 变化很大，也会造成内存资源浪费
            // 而且也造成了方法不再线程安全
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        cache[n] = result;
        return result;
    }
}

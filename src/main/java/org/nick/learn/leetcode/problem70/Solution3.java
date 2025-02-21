package org.nick.learn.leetcode.problem70;

public class Solution3 {

    // 迭代、递归 或 矩阵快速幂等方法

    // 迭代
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    //
    // 超快的，理论上递归是否也可以这么缓存？
    public int climbStairs(int n) {
        int cashe1 = 1, cashe2 = 2;
        if(1 == n){
            return cashe1;
        }
        if(2 == n){
            return cashe2;
        }
        int result = 0;
        for(int i = 3; i <= n; i++){
            result = cashe1 + cashe2;
            cashe1 = cashe2;
            cashe2 = result;
        }
        return result;
    }
}

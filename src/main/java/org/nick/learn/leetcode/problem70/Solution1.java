package org.nick.learn.leetcode.problem70;

public class Solution1 {

    // 回溯
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int n1 = 0;
        if (n - 1 > 0) {
            n1 = climbStairs(n - 1);
        }
        int n2 = 0;
        if (n - 2 > 0) {
            n2 = climbStairs(n - 2);
        }
        return n1 + n2;
    }


}

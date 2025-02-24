package org.nick.learn.leetcode.problem70;

public class Solution1 {

    // 递归 超时了
//    public int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        int n1 = 0;
//        if (n - 1 > 0) {
//            n1 = climbStairs(n - 1);
//        }
//        int n2 = 0;
//        if (n - 2 > 0) {
//            n2 = climbStairs(n - 2);
//        }
//        return n1 + n2;
//    }

    // 代码可以简洁一些
    public int climbStairs(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


}

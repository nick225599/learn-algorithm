package org.nick.learn.leetcode.problem69;

public class Solution7 {

    // 计算法 开根号x = e ^ (1/2 * lnx)
    public int mySqrt(int x) {
        double tmp = Math.exp(0.5 * Math.log(x));
        int result = (int) tmp;

        //TODO nick 20250305 为啥力扣第 69 题的这个官方题解，不用修正值过大的情况？

        // 修正值过大
         if ((long) result * result > x) {
         return result - 1;
         }

        // 修正值过小
        if ((long) (result + 1) * (result + 1) <= x) {
            return result + 1;
        }

        return result;
    }

}

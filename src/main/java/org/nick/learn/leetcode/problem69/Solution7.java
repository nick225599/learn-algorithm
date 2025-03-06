package org.nick.learn.leetcode.problem69;

public class Solution7 {

    // 计算法 开根号x = e ^ (1/2 * lnx)
    public int mySqrt(int x) {
        double tmp = Math.exp(0.5 * Math.log(x));
        int result = (int) tmp;

        // Q: nick 20250305 为啥力扣第 69 题的这个官方题解，不用修正值过大的情况？
        // A: 原则上浮点数运算结果是不准确的，下述修正方式也仅是在题解范围内的 x 有效，生产环境中不适宜直接进行这样的浮点运算
        // 除非换用 BigDecimal 以及基于 BigDecimal 的 exp() 和 log() 方法

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

package org.nick.learn.leetcode.problem69;

public class Solution7 {

    // 计算法 开根号x = e ^ (1/2 * lnx)
    public int mySqrt(int x) {
        int result = (int) Math.exp(0.5 * Math.log(x));
//        if ((long) result * result > x) {
//            return result - 1;
//        }
        if ((long) (result + 1) * (result + 1) <= x) {
            return result + 1;
        }
        return result;
    }

}

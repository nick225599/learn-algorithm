package org.nick.learn.leetcode.problem69;

import org.nick.learn.algorithm.utils.IntegerUtils;

public class Solution10 {

    // 位运算法
    public int mySqrt(int x) {
        int mask = 0x80000000;
        int result = 0;
        while (mask != 0) {
            int tmpResult = result ^ mask;
            long tmpResultSqrt = (long) tmpResult * tmpResult;
            if (tmpResultSqrt < x) {
                result = tmpResult;
            } else if (tmpResultSqrt == x) {
                return tmpResult;
            }
            mask >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 25;
        System.out.println("sqrt of " + x + ": " + new Solution10().mySqrt(x));
    }

}
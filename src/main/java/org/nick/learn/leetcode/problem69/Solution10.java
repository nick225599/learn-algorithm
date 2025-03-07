package org.nick.learn.leetcode.problem69;

import org.nick.learn.algorithm.utils.IntegerUtils;

public class Solution10 {

    // 位运算法
    public int mySqrt(int x) {
        int mask = 0x40000000;
        int result = 0;
        while (mask != 0) {
            int tmpResult = result ^ mask;

            //TODO nick 20250307 怎么解决 tmpResultSqrt 的计算会溢出？
            long tmpResultSqrt = (long) tmpResult * tmpResult;

            if (tmpResultSqrt < x) {
                result = tmpResult;
            } else if (tmpResultSqrt == x) {
                return tmpResult;
            }
            mask >>= 1;
        }
        return result;
    }



}
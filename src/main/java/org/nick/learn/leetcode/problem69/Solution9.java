package org.nick.learn.leetcode.problem69;

import org.nick.learn.algorithm.utils.IntegerUtils;

public class Solution9 {
    public static void main(String[] args) {
        int x = 25;
        System.out.println(new Solution9().mySqrt(x));
    }

    // 逐位算法
    public int mySqrt(int x) {
        int m = 0x40000000, y = 0, b;

        while (m != 0) {
            b = y ^ m;
            y = y >> 1;
            if (x >= b) {
                x = x - b;
                y = y ^ m;
            }
            m = m >> 2;
        }
        return y;
    }


}
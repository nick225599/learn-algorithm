package org.nick.learn.leetcode.p190;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P190Solution2 {
    // 时间复杂度 O(1)
    //
    // 颠倒给定的 32 位无符号整数的二进制位。
    // you need treat n as an unsigned value
    // 时间复杂度 O(logn) logn表示 n 在二进制下的表达长度
    public int reverseBits(int n) {

        int M1 = 0b0101_0101_0101_0101_0101_0101_0101_0101;
        int M2 = 0b0011_0011_0011_0011_0011_0011_0011_0011;
        int M3 = 0b0000_1111_0000_1111_0000_1111_0000_1111;
        int M4 = 0b0000_0000_1111_1111_0000_0000_1111_1111;
        int M5 = 0b0000_0000_0000_0000_1111_1111_1111_1111;

        n = (n >> 16 & M5) | ((n & M5) << 16);
        n = (n >> 8 & M4) | ((n & M4) << 8);
        n = (n >> 4 & M3) | ((n & M3) << 4);
        n = (n >> 2 & M2) | ((n & M2) << 2);
        n = (n >> 1 & M1) | ((n & M1) << 1);

        return n;
    }
}

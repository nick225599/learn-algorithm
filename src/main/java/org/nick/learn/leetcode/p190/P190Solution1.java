package org.nick.learn.leetcode.p190;

public class P190Solution1 {
    // 颠倒给定的 32 位无符号整数的二进制位。
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            result <<= 1;
            if(n % 2 != 0){
                result ^= 1;
            }
            n >>= 1;
        }
        return result;
    }
}

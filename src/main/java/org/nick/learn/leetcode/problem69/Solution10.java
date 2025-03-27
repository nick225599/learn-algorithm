package org.nick.learn.leetcode.problem69;

public class Solution10 {
    public static void main(String[] args) {
        int x = 25;
        System.out.println(new Solution10().mySqrt(x));
    }

    public int mySqrt(int x) {
        int m = 0x40000000; // 0100 0000, 0000 0000, 0000 0000, 0000 0000
        int y = 0;
        int b;

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
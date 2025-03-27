package org.nick.learn.leetcode.problem69;

public class Solution12 {
    public int mySqrt(int num) {
        if (num == 0) {
            return 0;
        }
        int result = 0;
        int bit = 1 << 30;
        while (bit > num) {
            bit >>= 2;
        }
        while (bit != 0) {
            if (num >= result + bit) {
                num -= result + bit;
                result = (result >> 1) + bit;
            } else {
                result >>= 1;
            }
            bit >>= 2;
        }
        return result;
    }
}

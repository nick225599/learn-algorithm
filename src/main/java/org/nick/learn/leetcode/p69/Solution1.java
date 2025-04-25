package org.nick.learn.leetcode.p69;

public class Solution1 {
    public int mySqrt(int x) {
        int sqrt = x / 2;
        while (true) {
            int square = sqrt * sqrt;
            if (square > x) {
                sqrt /= 2;
            } else if (square < x) {
                sqrt += 1;
            } else {
                break;
            }
        }
        return sqrt;
    }
}

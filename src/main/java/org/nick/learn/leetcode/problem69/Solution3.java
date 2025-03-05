package org.nick.learn.leetcode.problem69;

public class Solution3 {

    // 试位法（二分法）
    public int mySqrt(int x) {
        return mySqrt(x, 0, x);
    }

    // (min, max]
    private int mySqrt(int x, int min, int max) {
        // Q: nick 怎么解决 1, 0, 1 的问题？
        // A: AI 给出了精度更高的解法
        if(min + 1 == max){
            return max;
        }

        int mid = min + ((max - min) >> 1);
        int square = mid * mid;
        if (square < x) {
            return mySqrt(x, mid, max);
        } else if (square > x) {
            return mySqrt(x, min, mid);
        } else {
            return mid;
        }
    }
}

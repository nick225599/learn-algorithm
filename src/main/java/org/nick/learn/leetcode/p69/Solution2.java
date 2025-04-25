package org.nick.learn.leetcode.p69;

public class Solution2 {

    // 试位法（二分法）
    // TODO nick 20250305 还可以尝试牛顿迭代法
    // TODO nick 20250305 对数法
    // TODO nick 20250305 长除法
    public int mySqrt(int x) {
        return mySqrt(x, 0, x);
    }

    private int mySqrt(int x, double min, double max) {
        double tmp = min + ((max - min) / 2);
        if(min == tmp || tmp == max){
            return (int) tmp;
        }
        double square = tmp * tmp;
        if (square > x) {
            return mySqrt(x, min, tmp);
        } else if (square < x) {
            return mySqrt(x, tmp, max);
        } else {
            return (int) tmp;
        }
    }
}

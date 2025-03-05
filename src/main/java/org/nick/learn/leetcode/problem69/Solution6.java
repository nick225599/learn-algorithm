package org.nick.learn.leetcode.problem69;

public class Solution6 {

    // 试位法（二分法）
    // 尝试将官方题解改成递归

    // 回过头来看看自己的解法，自己没有想到 mid * mid <= x 的处理技巧
    public int mySqrt(int x) {
        return mySqrt(x, 0, x);
    }

    private int mySqrt(int x, int l, int r) {
        if (l > r) {
            return -1;
        }
        int mid = l + ((r - l) >> 1);
        long tmp = (long) mid * mid;
        if (tmp <= x) {
            int nextResult = mySqrt(x, mid + 1, r);
            return Math.max(mid, nextResult);
        } else {
            return mySqrt(x, l, mid - 1);
        }
    }


}

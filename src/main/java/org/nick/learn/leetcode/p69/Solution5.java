package org.nick.learn.leetcode.p69;

public class Solution5 {

    // 试位法（二分法）
    // 官方题解
    public int mySqrt(int x) {
        int l = 0, r = x;
        int result = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (((long) mid * mid) <= x) {
                l = mid + 1;
                result = mid;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }


}

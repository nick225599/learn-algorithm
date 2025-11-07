package org.nick.learn.leetcode.p50;

public class P50Solution2 {

    // 朴素算法，超出时间限制
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            double ans = x;
            for (int i = 2; i <= n; i++) {
                ans *= x;
            }
            return ans;
        } else {
            double ans = x;
            for (int i = 2; i <= -n; i++) {
                ans *= x;
            }
            return 1 / ans;
        }
    }
}

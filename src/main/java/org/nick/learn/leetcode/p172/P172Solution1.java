package org.nick.learn.leetcode.p172;

import java.math.BigInteger;

public class P172Solution1 {

    // 朴素解法
    // n = 7261 时超出时间限制
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }

        BigInteger factorial = new BigInteger("1");
        for (int i = n; i >= 1; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String strFactorial = factorial.toString();
        int count = 0;
        for (int i = strFactorial.length() - 1; i >= 0; i--) {
            if (strFactorial.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

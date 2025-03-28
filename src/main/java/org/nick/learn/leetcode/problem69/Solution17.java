package org.nick.learn.leetcode.problem69;

public class Solution17 {
    public static void main(String[] args) {
        int n = 2147395599;
        int sqrt = new Solution17().mySqrt(n);
        System.out.println();
        System.out.println("Decimal sqrt: " + sqrt);
    }

    /**
     * 计算整方根函数
     * 采用手算开平方方法（二进制）
     */
    public int mySqrt(int x) {
        long remainder = x;
        long a = 1 << 30;
        long result = 0;

        while (a > x) {
            a >>= 1;
        }

        while (a > 0) {
            long delta = a * a + 2 * a * result;
            if (delta <= remainder) {
                result = result | a;
                remainder = remainder - delta;
            }

            a >>= 1;
        }

        return (int) result;
    }
}

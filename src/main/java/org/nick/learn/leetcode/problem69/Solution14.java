package org.nick.learn.leetcode.problem69;

public class Solution14 {
    public static void main(String[] args) {
        int n = 0b11;
        System.out.println("Binary sqrt: " + Integer.toBinaryString(n));
        System.out.println("Decimal sqrt: " + n);
        int sqrt = new Solution14().mySqrt(n);
        System.out.println("Binary sqrt: " + Integer.toBinaryString(sqrt));
        System.out.println("Decimal sqrt: " + sqrt);
    }

    /**
     * 整方根函数
     * 手算开平方方法（二进制）
     */
    public int mySqrt(int n) {
        if (n < 0) throw new IllegalArgumentException();
        if (n == 0) return 0;

        int result = 0; // 已确定的平方根
        int bit = 1 << 30;

        while (bit > n) {
            bit >>= 2;
            System.out.println("tmp bit: " + Integer.toBinaryString(bit));
        }
        System.out.println("Binary bit: " + Integer.toBinaryString(bit));
        System.out.println("Decimal bit: " + bit);

        while (bit != 0) {
            int temp = result | bit;
            if (n >= temp) {
                n -= temp;
                result = (result >> 1) | bit;
            } else {
                result >>= 1;
            }
            bit >>= 2;
        }
        return result;
    }
}

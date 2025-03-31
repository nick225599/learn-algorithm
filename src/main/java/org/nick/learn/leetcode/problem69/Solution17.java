package org.nick.learn.leetcode.problem69;

public class Solution17 {
    public static void main(String[] args) {
        int n = 25;
        int sqrt = new Solution17().mySqrt(n);
        System.out.println();
        System.out.println("Decimal sqrt: " + sqrt);
    }

    /**
     * 计算整方根函数
     * 采用手算开平方方法（二进制）
     */
    public int mySqrt(int x) {
        int temp;
        int vBit = 15; // 使用int代替unsigned
        int n = 0;     // 同上
        int b = 0x8000;

        if (x <= 1) {
            return x; // 强制转换，适用于x为0或1的情况
        }

        do {
            temp = (( n << 1) + b) << vBit--;
            if (x >= temp) {
                n += b;
                x -= temp;
            }
        } while ((b >>= 1) != 0); // 使用无符号右移

        return n;
    }
}

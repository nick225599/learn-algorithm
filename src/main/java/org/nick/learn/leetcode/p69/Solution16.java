package org.nick.learn.leetcode.p69;

public class Solution16 {
    public static void main(String[] args) {
        int n = 25;
        int sqrt = new Solution16().mySqrt(n);
        System.out.println();
        System.out.println("Binary sqrt: " + Integer.toBinaryString(sqrt));
        System.out.println("Decimal sqrt: " + sqrt);
        System.out.println("n:" + n);
    }

    /**
     * 计算整方根函数
     * 采用手算开平方方法（二进制）
     */
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        if (x == 0 || x == 1) {
            return x;
        }

        int pei; // 两位一组分组，每一组的结束位置

        // 计算出第 1 组的结束位置
        pei = 0b0100_0000__0000_0000__0000_0000__0000_0000;
        while (pei > x) {
            pei >>= 2;
        }

        int p = x; // 剩余被开方数
        int dm = 0;
        while (pei > 0) {
            int tmp = dm | pei;
            if (tmp <= p) {
                dm = (dm >> 1) | pei;
                p = p - tmp;
            } else {
                dm = dm >> 1;
            }

            pei = pei >> 2; // 两两一组，准备开始评估下一组
        }

        return dm;
    }
}

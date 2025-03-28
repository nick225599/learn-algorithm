package org.nick.learn.leetcode.problem69;

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
     * 整方根函数
     * 手算开平方方法（二进制） 并尝试简化
     */
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        if (x == 0 || x == 1) {
            return x;
        }

        int pei = 1 << 30; // 两位一组分组，每一组的结束位置

        // 计算出第 1 组的结束位置
        while (pei > x) {
            pei >>= 2;
        }

        int result = 0;
        int p = x;
        while (pei > 0) {
            int tmp = result | pei;
            if (p >= tmp) {
                p = p - tmp;
                result = (result >> 1) | pei;
            } else {
                result = result >> 1;
            }

            pei = pei >> 2; // 两两一组，准备开始评估下一组
        }

        return result;
    }
}

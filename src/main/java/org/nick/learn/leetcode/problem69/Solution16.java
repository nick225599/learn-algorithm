package org.nick.learn.leetcode.problem69;

public class Solution16 {
    public static void main(String[] args) {
        int n = 25;
        int sqrt = new Solution16().mySqrt(n);
        System.out.println();
        System.out.println("Binary sqrt: " + Integer.toBinaryString(sqrt));
        System.out.println("Decimal sqrt: " + sqrt);
        System.out.println("n:" + n );
    }

    /**
     * 整方根函数
     * 手算开平方方法（二进制） 并尝试简化
     */
    public int mySqrt(int n) {
        int mask = 1 << 30;
        while(mask > n){
            mask >>= 2;
        }

        int result = 0;
        while (mask != 0) {
            int tmp = result | mask;
            result = result >> 1;
            if (n >= tmp) {
                n = n - tmp;
                result = result | mask;
            }
            mask = mask >> 2;
        }
        return result;
    }
}

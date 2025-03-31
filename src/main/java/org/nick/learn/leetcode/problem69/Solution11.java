package org.nick.learn.leetcode.problem69;

/**
 * b 站版本
 * https://www.bilibili.com/video/BV1Qe411P7rs/
 */
public class Solution11 {
    public static void main(String[] args) {
        int x = 7;
        System.out.println(new Solution11().mySqrt(x));
    }

    /**
     * 求解 n 的平方根的整数部分
     */
    public int mySqrt(int n) {
        int x = n;
        int cm = 0;
        int dm = 1 << 30;
        while (dm > n) {
            dm >>= 2;
        }
        while (dm > 0) {
            if (x >= cm + dm) {
                x -= (cm + dm);
                cm = (cm >> 1) + dm;
            } else {
                cm >>= 1;
            }
            dm >>= 2;
        }
        return cm;
    }

}



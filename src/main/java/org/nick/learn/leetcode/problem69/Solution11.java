package org.nick.learn.leetcode.problem69;

/**
 * b 站版本
 * https://www.bilibili.com/video/BV1Qe411P7rs/
 */
public class Solution11 {
    public static void main(String[] args) {
        int x = 4;
        System.out.println(new Solution11().mySqrt(x));
    }

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
                cm = (cm >> 1) + (dm >>1);
            } else {
                cm >>= 1;
            }
            dm >>= 2;
        }
        return cm;
    }

}



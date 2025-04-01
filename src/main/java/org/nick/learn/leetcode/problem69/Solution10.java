package org.nick.learn.leetcode.problem69;

public class Solution10 {
    public static void main(String[] args) {
        int x = 1234;
        System.out.println(new Solution10().mySqrt(x));
    }

    // https://blog.csdn.net/Poo_Chai/article/details/101976547
    // 代码来自《Hacker's Delight》(高效程序的奥秘)一书的第11章.
    public int mySqrt(int x) {
        int m = 1 << 30;
        int y = 0;
        int b;

        while (m != 0) {
            b = y ^ m;
            y = y >> 1;
            if (x >= b) {
                x = x - b;
                y = y ^ m;
            }
            m = m >> 2;
        }
        return y;
    }


}
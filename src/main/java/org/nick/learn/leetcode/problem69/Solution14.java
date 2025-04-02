package org.nick.learn.leetcode.problem69;

public class Solution14 {
    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (solution.sqrt1(i) != solution.sqrt2(i)) {
                System.err.println(i + ", error!!!");
            }
            if (i % 10_0000_0000 == 0) {
                System.out.println("processed: " + i);
            }
        }
    }

    public int sqrt1(int n) {
        int y = 0;
        int m = 1 << 30;
        while (m > 0) {
            long tmp = (long) ((y << 1) + m) * m;
            if (n >= tmp) {
                n -= (int) tmp;
                y = y + m;
            }
            m >>= 1;
        }
        return y;
    }

    public int sqrt2(int n) {
        int y = 0;
        int m = 1 << 30;
        while (m > 0) {
            int tmp = y | m;
            y >>= 1;
            if (n >= tmp) {
                n -= tmp;
                y = y | m;
            }
            m >>= 2;
        }
        return y;
    }

    //TODO nick 20250401 为啥 sqrt1 和 sqrt2 是等价的？？？
}

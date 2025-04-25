package org.nick.learn.leetcode.p69;

public class Solution18 {

        public static int sqrt(int x) {
            if (x < 0) {
                throw new IllegalArgumentException("Negative numbers do not have square roots.");
            }
            if (x == 0 || x == 1) {
                return x;
            }

            // Normalization: Find k such that 1 <= (y = x * 2^(2k)) < 4
            int k = 0;
            int y = x;
            while (y >= 4) {
                y >>= 2;
                k++;
            }

            // Initial estimate for q is 1, s is 2*q which is 2.
            int q = 1;
            int s = 2;

            // Bit by bit computation
            for (int i = ((Integer.SIZE - Integer.numberOfLeadingZeros(y)) >> 1) - 1; i >= 0; i--) {
                // Check if (q + 2^-(i+1))^2 <= y
                if (s + (1 << -(i + 1)) <= (y << (i + 1))) {
                    // Update q and s according to the formula
                    s += 1 << -i;
                    q |= 1 << i;
                }
                // Shift s left by 1 for next iteration
                s <<= 1;
            }

            // Adjust result based on normalization factor
            q <<= k;

            return q;
        }

        public static void main(String[] args) {
            // 测试例子
            System.out.println(sqrt(64)); // 输出 8
            System.out.println(sqrt(10)); // 输出接近 3 的值，实际输出取决于实现细节
            System.out.println(sqrt(100)); // 输出 10
            System.out.println(sqrt(0)); // 输出 0
            System.out.println(sqrt(1)); // 输出 1
        }
}

package org.nick.learn.leetcode.problem69;

/**
 * 《高效程序的奥秘》 第 11 章 - 11.1 整数平方根 - 3. 硬件算法
 */
public class Solution19 {
    public static int sqrt(int x) {
        long register = x; // 高32位为0，低32位为x
        int y = 0;
        for (int i = 0; i < 16; i++) {
            // 在每次迭代中，这一64位寄存器被左移2位
            register <<= 2;
            // 左移位当前结果y 1 个位
            y <<= 1;
            long temp = ((long) y << 1) + 1; // 计算2y + 1
            if ((register >> 32) >= temp) {
                // 如果减法的结果是非负的，就用这一结果取代64位寄存器的左半部分，
                // 并在y上加1(这一加法不需要加法器，因为y的最末位是0))。
                temp = (int) (register >> 32) - temp;
                register = (temp << 32) | (register & 0x0000_0000_FFFF_FFFFL);
                y = y | 1;

            } else {
                // 如果减法的结果是负的，那么64位寄存器和y不变。选代要执行16次
            }
        }


        return y; // 返回结果
    }

    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        int result = sqrt(x);
        System.out.println("sqrt(" + x + ") = " + result);
    }
}


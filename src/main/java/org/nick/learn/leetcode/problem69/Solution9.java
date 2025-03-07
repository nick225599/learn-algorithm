package org.nick.learn.leetcode.problem69;

import org.nick.learn.algorithm.utils.IntegerUtils;

public class Solution9 {
    // 实现一个方法来计算给定整数x的平方根（只取整数部分）
    public int mySqrt(int x) {
        System.out.println("x: ");
        System.out.println(IntegerUtils.toBinaryString32(x));
        System.out.println();

        // 初始化m为0x40000000，即二进制下的0100 0000 ... 0000。这表示从最高有效位开始尝试找到平方根的二进制表示。
        // m = 0100 0000, 0000 0000, 0000 0000, 0000 0000
        int mask = 0x40000000; // 掩码
        int result = 0; // y初始化为0，用于逐步构建平方根的值；
        int b = 0; // b初始化为0，用于临时存储中间计算结果。

        // 循环直到m变为0，即检查完所有可能的位。
        while (mask != 0) {
            // 将 result 与 mask 进行按位异或操作，并将结果赋值给b。
            // 这里尝试通过改变 result 的值来试探平方根的当前位是否应设为 1。
            b = result ^ mask;
            System.out.println("result: ");
            System.out.println(IntegerUtils.toBinaryString32(result));
            System.out.println("mask: ");
            System.out.println(IntegerUtils.toBinaryString32(mask));
            System.out.println("b: ");
            System.out.println(IntegerUtils.toBinaryString32(b));
            System.out.println();

            // 将y右移一位，为下一次迭代做准备。
            result = result >> 1;
            System.out.println("result: ");
            System.out.println(IntegerUtils.toBinaryString32(result));
            System.out.println();

            // 如果x大于等于b，说明当前试探的平方根值是可行的。
            if (x >= b) {
                // 从x中减去b，更新剩余需要匹配的平方和。
                x = x - b;

                // 更新y，将其与m进行异或操作，确认当前位为1。
                result = result ^ mask;

                // 打印当前构建的平方根值的二进制表示（主要用于调试）。
                System.out.println("current y: 0x" + Integer.toBinaryString(result));
            }

            // 将m右移两位，以检查下一个较低的有效位。
            System.out.println("before m >> 2, m: " + IntegerUtils.toBinaryString32(mask));
            mask = mask >> 2;
            System.out.println("after  m >> 2, m: " + IntegerUtils.toBinaryString32(mask));
        }

        // 返回计算得到的平方根的整数部分。
        return result;
    }

    // 主函数，用于测试mySqrt方法。
    public static void main(String[] args) {
        // 定义输入值x为25。
        int x = 25;

        // 调用mySqrt方法并打印结果：原始x值及其平方根的整数部分。
        System.out.println("x: " + x + ", sqrt of x: " + new Solution9().mySqrt(x));
    }


}
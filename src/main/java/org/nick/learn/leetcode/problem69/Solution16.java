package org.nick.learn.leetcode.problem69;

public class Solution16 {
    public static void main(String[] args) {
        int n = 25;
        int sqrt = new Solution16().mySqrt(n);
        System.out.println();
        System.out.println("Binary sqrt: " + Integer.toBinaryString(sqrt));
        System.out.println("Decimal sqrt: " + sqrt);
    }

    /**
     * 整方根函数
     * 手算开平方方法（二进制） 并尝试简化
     */
    public int mySqrt(int n) {
        String strN = Integer.toBinaryString(n);
        int lengthN = strN.length();

        // 数位分组，两位一组
        int psi = 0; // 当前组的起始索引（包含）
        int pei = (lengthN % 2 != 0) ? 1 : 2; // 当前组的结束索引（不包含）

        int a = 0; // 已确定的平方根部分
        int x = 0; // 当前被除数（含余数）

        for (; pei <= lengthN; pei += 2, psi = pei - 2) {
            String pair = strN.substring(psi, pei);
            System.out.print(pair + " | ");
            int iPair = Integer.parseInt(pair, 2);

            // 更新被除数
            x = (x << 2) | iPair;

            // 寻找最大 b， 满足 4ab + b^2 <= x
            int rightB = 0;
            int maxTmp = 0;
            for (int b = 0; b < 2; b++) {
                int tmp = (4 * a * b + b * b);
                if (tmp <= x) {
                    rightB = b;
                    maxTmp = tmp;
                } else {
                    break;
                }
            }

            // 更新已经确定的平方根
            a = (a << 1) + rightB;

            // 计算评估完当前位的余数
            x = x - maxTmp;
        }

        return a;
    }
}

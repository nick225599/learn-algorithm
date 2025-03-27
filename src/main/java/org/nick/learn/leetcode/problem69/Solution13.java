package org.nick.learn.leetcode.problem69;

/**
 * 手算开平方方法（十进制）
 * 每确定一位数字，相当于在当前的近似值后面加上下一位数字b，使得新的平方不超过原数。
 * 这时候，原来的近似值是a，现在变成10a + b，那么平方差就是(10a + b)^2 - (10a)^2 = 20ab + b² = b*(20a + b)。
 * 因此，当我们在余数后面加上接下来的两位时，实际上在寻找最大的b，使得这个b*(20a + b)不超过当前的余数加上新拉下来的两位组成的数。
 * 这样，每一步都是在逐步逼近正确的平方根，每次确定下一位的数字。
 */
public class Solution13 {
    public static void main(String[] args) {


        int n = 25;
        int sqrt = new Solution13().mySqrt(n);
        System.out.println();
        System.out.println("sqrt:  " + sqrt);
        if (sqrt == 5) {
            System.out.println("计算正确");
        } else {
            System.err.println("计算错误，25 的平方根应该是 5，但程序计算出的结果却是: " + sqrt);
        }
    }

    public int mySqrt(int n) {
        String strN = String.valueOf(n);
        int lengthN = strN.length();

        // 数位分组，两位一组
        int psi = 0; // 当前组的起始索引（包含）
        int pei = (lengthN % 2 != 0) ? 1 : 2; // 当前组的结束索引（不包含）

        int a = 0; // 已确定的平方根部分
        int x = 0; // 当前被除数（含余数）

        for (; pei <= lengthN; pei += 2, psi = pei - 2) {
            String pair = strN.substring(psi, pei);
            System.out.print(pair + " | ");
            int iPair = Integer.parseInt(pair);

            // 更新被除数
            x = x * 100 + iPair;

            // 寻找最大 b，满足 (20 * a + b) * b <= x
            int rightB = 1;
            int maxTmp = 0;
            for (int b = 0; b < 10; b++) {
                int tmp = (20 * a * b + b * b);
                if (tmp <= x) {
                    rightB = b;
                    maxTmp = tmp;
                }else {
                    break;
                }
            }

            // 更新已确定的平方根
            a = 10 * a + rightB;
            // 计算余数
            x = x - maxTmp;

        }
        return a;
    }


}

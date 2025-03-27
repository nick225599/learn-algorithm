package org.nick.learn.leetcode.problem69;

// 手算开平方方法
public class Solution13 {
    public static void main(String[] args) {

        // 9481 * 9481 = 89889361;
        int n = 89889361;
        int sqrt = new Solution13().mySqrt(n);
        System.out.println();
        System.out.println("sqrt:  " + sqrt);
//        if (sqrt == 5) {
//            System.out.println("计算正确");
//        } else {
//            System.err.println("计算错误，25 的平方根应该是 5，但程序计算出的结果却是: " + sqrt);
//        }
    }

    public int mySqrt(int n) {
        String strN = String.valueOf(n);
        int lengthN = strN.length();

        // 数位分组，两位一组
        int psi = 0; // 当前组的起始索引（包含）
        int pei = (lengthN % 2 != 0) ? 1 : 2; // 当前组的结束索引（不包含）

        int x = 0; // 当前被除数（含余数）
        int a = 0; // 已确定的平方根部分

//        while (pei <= lengthN) {
//            // 获取当前两位分组
//            String strPair = strN.substring(psi, pei);
//            int pair = Integer.parseInt(strPair);
//
//            // 更新被除数
//            x = 100 * x + pair;
//
//            // 寻找最大 b，满足 (20 * a + b) * b <= x
//            int b = 0;
//            int maxTmp = 0;
//            for (int candidate = 0; candidate < 10; candidate++) {
//                int tmp = 20 * a * candidate + candidate * candidate;
//                if (tmp <= x) {
//                    b = candidate;
//                    maxTmp = tmp;
//                } else {
//                    break;
//                }
//            }
//
//            // 更新平方根
//            a = 10 * a + b;
//            // 更新余数
//            x = x - maxTmp;
//
//            pei += 2;
//            psi = pei - 2;
//        }

        for (; pei <= lengthN; pei += 2, psi = pei - 2) {
            String pair = strN.substring(psi, pei);
            System.out.print(pair + " | ");
            int iPair = Integer.parseInt(pair);
            x = x * 100 + iPair;

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
            if(x == 0){
                break;
            }
        }
        return a;
    }


}

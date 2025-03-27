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

        // 数位分组，两位一组
        int psi = 0; // pair start index
        int pei = 1; // pair end index
        if (strN.length() % 2 == 0) {
            pei += 1;
        }

        int x = 0; // 被除数
        int a = 0; // 已确定的平方根部分
        for (; pei <= strN.length(); pei += 2, psi = pei - 2) {
            String pair = strN.substring(psi, pei);
            System.out.print(pair + " | ");
            int iPair = Integer.parseInt(pair);
            x = x * 100 + iPair;

            int rightB = 1;
            int tmp = 0;
            for(int b = 0; b < 10; b ++){
                tmp = (20 * a * b + b * b);
                if(tmp <= x){
                    rightB  = b;
                }
            }

            // 更新已确定的平方根
            a = 10 * a +  rightB;

            // 计算余数
            x = x - tmp;

            if(x == 0){
                break;
            }
        }
        return a;
    }


}

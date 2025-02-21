package org.nick.learn.leetcode.problem70;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Solution2 {
    private static final MathContext MC = new MathContext(100, RoundingMode.HALF_UP); // 设置精度为 100 位

    // 使用 Binet 公式计算斐波那契数，失败，就算弄懂了，公式我也看不懂...
    public int fibonacci(int n) {
        return -1;

//        if(n == 1){
//            return 1;
//        }
//        if(n == 2){
//            return 2;
//        }
//        BigDecimal sqrt5 = BigDecimal.valueOf(5).sqrt(MC); // 计算 √5
//        BigDecimal phi = BigDecimal.ONE.add(sqrt5).divide(BigDecimal.valueOf(2), MC); // 黄金比例 φ
//        BigDecimal psi = BigDecimal.ONE.subtract(sqrt5).divide(BigDecimal.valueOf(2), MC); // 补数 ψ
//
//        // 计算 φ^n 和 ψ^n
//        BigDecimal phiN = phi.pow(n, MC);
//        BigDecimal psiN = psi.pow(n, MC);
//
//        // 应用 Binet 公式
//        BigDecimal fib = phiN.subtract(psiN, MC).divide(sqrt5, MC);
//
//        return fib.setScale(0, RoundingMode.HALF_UP).intValue(); // 四舍五入到整数
    }

//    public static void main(String[] args) {
//        for(int i = 1; i <= 100; i++){
//            int result1 = new Solution1().climbStairs(i);
//            int result2 = new Solution2().fibonacci(i);
//            if(result1 != result2){
//                System.out.println("i: " + i);
//                throw new RuntimeException();
//            }
//        }
//    }

}

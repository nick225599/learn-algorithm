package org.nick.learn.leetcode.problem69;

public class Solution4 {

    // 试位法（二分法）
    // AI 给出的精度更高版本，实际还是没能解决问题
    public int mySqrt(int x) {
        return mySqrt(x, 0, x, 1e-7); // 精度为 1e-7
    }

    private int mySqrt(double x, double min, double max, double epsilon) {
        double mid = min + (max - min) / 2; // 计算中点
        double square = mid * mid;

        if (Math.abs(square - x) < epsilon) {
            System.out.println("x: " + x + ", mid: " + mid);
            return (int) mid; // 满足精度要求
        } else if (square < x) {
            return mySqrt(x, mid, max, epsilon); // 目标值在右区间
        } else {
            return mySqrt(x, min, mid, epsilon); // 目标值在左区间
        }
    }
}

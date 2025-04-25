package org.nick.learn.leetcode.p69;

public class Solution8 {
    public static void main(String[] args) {
        double b = 2.999_999_999_9;
        int x = (int) (b * b);
        System.out.println(new Solution8().mySqrt(x));
    }

    // 牛顿迭代法
    // X(k+1) = 1/n * ( (n-1) * X(k) + a / ( (X(k)) ^ n-1 ) )
    // n = 2 时
    // X(k+1) = 1/2 * (   X(k) + a /( X(K) )   )

    // 0 <= x <= 231 - 1
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        double epsilon = 1e-10;
        System.out.println("epsilon: " + String.format("%.12f", epsilon));

        double curNum = x;
        double nextNum;
        while (true) {
            nextNum = getNextNum(x, curNum);
            double delta = Math.abs(nextNum - curNum);

            if (delta <= epsilon) {
                break;
            }

            curNum = nextNum;
            System.out.println("curNum: " + curNum);
        }

        //Q: nick 怎么对近似值进行处理，拿到相近值？ 2.999999......9 要入成3
        // 而 2.8 要舍成 2？

        //A：检查是否需要调整结果
        int result = (int) curNum;
        if (result > 1 && (long) result * (result) > x) {
            result--;
        }


        return result;


    }

    /**
     * TODO 怎么避免浮点数运算的偏差影响结果？
     * <p>
     * X(k+1) = 1/2 * (   X(k) + a /X(K)   )
     */
    public double getNextNum(long a, double curNum) {
        return 0.5 * (curNum + a / curNum);
    }

}

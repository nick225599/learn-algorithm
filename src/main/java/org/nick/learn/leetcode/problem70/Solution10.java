package org.nick.learn.leetcode.problem70;

import javax.naming.OperationNotSupportedException;

public class Solution10 {

    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/climbing-stairs/solutions/286022/pa-lou-ti-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     * //TODO 20250304 不太能理解怎么算齐次线性递推关系式的通项公式
     * //TODO 20250304 看了一些斐波那契数列的通项公式求解视频，看能看懂，但并不能get到解题人是怎么预判可以用 r^n 来作为特征值的。
     * //TODO 20250304 先跳过吧，补一补线性代数和离散数学再进一步说吧
     */
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }

}

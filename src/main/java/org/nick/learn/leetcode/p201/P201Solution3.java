package org.nick.learn.leetcode.p201;

public class P201Solution3 {

    // Brian Kernighan 算法
    // 时间复杂度：O(logn)。和位移方法类似，
    // 算法的时间复杂度取决于 m 和 n 二进制展开的位数。尽管和位移方法具有相同的渐近复杂度，
    // 但 Brian Kernighan 的算法需要的迭代次数会更少，因为它跳过了两个数字之间的所有零位。
    public int rangeBitwiseAnd(int left, int right) {
        int n = right;
        while (left < n) {
            n = n & n - 1;
        }
        return n;
    }
}

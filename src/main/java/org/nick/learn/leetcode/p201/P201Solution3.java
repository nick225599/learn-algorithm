package org.nick.learn.leetcode.p201;

public class P201Solution3 {

    // 为啥 while 条件是 left < right 而不是 left <= right
    // 为啥退出循环后不用再 & 一下 left ？

    // 当循环结束时（m >= n），有两种可能：
    //
    // 若m == n：此时 n 本身就是 m（也是 n）的值，n & m等价于 n，无需额外操作
    // 若m > n：说明在循环过程中，n 已经被缩减到比 m 还小。
    //   此时的 n 是 m~ 原始 n 之间所有数字的公共前缀，而 m 的二进制表示中，
    //   比这个公共前缀更长的部分（更靠右的位）一定包含 0（否则 n 不会被缩减到小于 m），
    //   所以n & m的结果仍然是 n
    public int rangeBitwiseAnd(int left, int right) {
        while(left < right){
             right = right & (right - 1);
        }
        return right;
    }
}

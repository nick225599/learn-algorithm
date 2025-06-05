package org.nick.learn.leetcode.p191;

public class P191Solution3 {

    // 为什么会这样？
    //
    // 当 n 的二进制末尾是 1 时（如 6 的 110），n-1 会将末尾的 1 变为 0，其余低位补 1（如 5 的 101）。
    // 此时 n & (n-1) 会保留高位的 1，但清除末尾的 1。
    //
    // 当 n 的二进制末尾是连续 k 个 0 时（如 8 的 1000），n-1 会将末尾的 0 变为 1，
    // 直到遇到第一个 1 并将其变为 0（如 7 的 0111）。
    // 此时 n & (n-1) 会清除最右边的那个 1（即原 n 中最右边的 1）。
    public int hammingWeight(int n) {
        int result = 0;
        while(n > 0){
            n &= (n - 1);
            result++;
        }
        return result;
    }

}

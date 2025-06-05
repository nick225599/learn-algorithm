package org.nick.learn.leetcode.p136;

public class P136Solution1 {

    // 知道异或运算的交换律就能一遍过，
    // 不知道的话，那就真解不出来了
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}

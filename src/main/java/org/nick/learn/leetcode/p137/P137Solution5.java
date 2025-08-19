package org.nick.learn.leetcode.p137;

public class P137Solution5 {

    //todo nick 20250819 待理解怎么用真值表设计出数字电路 https://www.doubao.com/thread/w233ee5acf878bd1c
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int aNext = (~a & b & num) | (a & ~b & ~num), bNext = ~a & (b ^ num);
            a = aNext;
            b = bNext;
        }
        return b;
    }

}

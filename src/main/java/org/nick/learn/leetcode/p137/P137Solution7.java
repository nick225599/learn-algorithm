package org.nick.learn.leetcode.p137;

public class P137Solution7 {

    // 数字电路优化
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        int nextA, nextB;
        for (int num : nums) {
            nextB = ~a & (b ^ num);
            nextA = ~nextB & (a ^ num);
            b = nextB;
            a = nextA;
        }
        return b;
    }

    // 0 + 0 = 0, 00 + 0 = 00, ai: 000->0, bi: 000->0
    // 0 + 1 = 1, 00 + 1 = 01, ai: 001->0, bi: 001->1 ~a & ~b & num = newB
    // 1 + 0 = 1, 01 + 0 = 01, ai: 010->0, bi: 010->1 ~a & b & ~num = newB
    // 1 + 1 = 2, 01 + 1 = 10, ai: 011->1, bi: 011->0
    // 2 + 0 = 2, 10 + 0 = 10, ai: 100->1, bi: 100->0
    // 2 + 1 = 0, 10 + 1 = 00, ai: 101->0, bi: 101->0
    int nextB(int a, int b, int num) {
        return ~a & (b ^ num);
    }

    // 0 + 0 = 0, 00 + 0 = 00, ai: 000->0, bi: 000->0, ai0,newBi0,num0, newAi0
    // 0 + 1 = 1, 00 + 1 = 01, ai: 001->0, bi: 001->1, ai0,newBi1,num1, newAi0
    // 1 + 0 = 1, 01 + 0 = 01, ai: 010->0, bi: 010->1, ai0,newBi1,num0, newAi0
    // 1 + 1 = 2, 01 + 1 = 10, ai: 011->1, bi: 011->0, ai0,newBi0,num1, newAi1, 001 -> 1
    // 2 + 0 = 2, 10 + 0 = 10, ai: 100->1, bi: 100->0, ai1,newBi0,num0, newAi1, 100 -> 1
    // 2 + 1 = 0, 10 + 1 = 00, ai: 101->0, bi: 101->0, ai1,newBi0,num1, newAi0
    int nextA(int a, int b, int num) {
        return ~b & (a ^ num);
    }


}

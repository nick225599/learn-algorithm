package org.nick.learn.leetcode.p137;

public class P137Solution6 {

    // 这种 “硬件思路软件实现” 的方式在算法中并不少见，
    // 尤其适合解决与 “计数、状态转换” 相关的位运算问题，
    // 能带来极高的效率（如本题的 O (1) 空间复杂度）。
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int aNext = this.calculateNewAi(a, b, num);
            int bNext = this.calculateNewBi(a, b, num);
            a = aNext;
            b = bNext;
        }

        //  在本题的解法中，符号位被当作普通二进制位参与运算——
        //  它的 “出现次数” 同样会被统计（模 3），与其他位的处理逻辑完全一致。
        //
        //  最终结果的符号位会自然正确

        // 00 出现 0 次
        // 01 出现 1 次
        // 10 出现 2 次
        // 00 出现 3 次
        // 所以 b 刚好等于出现 1 次的数，return b
        return b;
    }

    int calculateNewAi(int ai, int bi, int xi) {
        return ai & (~bi & 1) & (~xi & 1) | (~ai & 1) & bi & xi;
    }

    int calculateNewBi(int ai, int bi, int xi) {
        return (~ai & 1) & bi & (~xi & 1) | (~ai & 1) & (~bi & 1) & xi;
    }

    // 异或的逻辑：两个位不同时为 1，相同时为 0。
    // 数学表达：a ^ b = (a & ~b) | (~a & b)
    // 0 ^ 0 = 0, 0 & 1 | 1 & 0 = 0 | 0 = 0
    // 0 ^ 1 = 1, 0 & 0 | 1 & 1 = 0 | 1 = 1
    // 1 ^ 0 = 1, 1 & 1 | 0 & 0 = 1 | 0 = 1
    // 1 ^ 1 = 0, 1 & 0 | 0 & 1 = 0 | 0 = 0
    int calculateNewBi2(int ai, int bi, int xi) {
        return (~ai) & (bi ^ xi);
    }

}

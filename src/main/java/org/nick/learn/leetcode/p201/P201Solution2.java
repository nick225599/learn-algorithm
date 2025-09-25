package org.nick.learn.leetcode.p201;

public class P201Solution2 {

    int times;

    // 通过位移的方式求出公共前缀
    // 时间复杂度 log(n) n 表示 int 型的位数
    public int rangeBitwiseAnd(int left, int right) {
        times = 0;
        int shift = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
            times++;
        }
        System.out.println("times: " + times);
        return left << shift;
    }
}

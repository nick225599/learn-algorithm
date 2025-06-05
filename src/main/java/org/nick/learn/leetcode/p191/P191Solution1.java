package org.nick.learn.leetcode.p191;

public class P191Solution1 {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32 && n >= 0; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}

package org.nick.learn.leetcode.p28;

import java.util.Arrays;

public class P28Solution6 {

    /**
     * BM 算法
     * 跟着王争老师一步步实现好后缀规则
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (n < m) return -1;

        int[] badChar = new int[123];
        Arrays.fill(badChar, -1);
        for (int i = 0; i < m; i++) {
            badChar[needle.charAt(i)] = i;
        }

        int i = 0;
        while (i <= n - m) {
            int j = m - 1;
            while (j >= 0 && haystack.charAt(i + j) == needle.charAt(j)) {
                j--;
            }
            if (j < 0) {
                return i;
            }

            // aaabaaa
            // baaa
            //    baaa

            // 偏移量 = 失配符号在模式串中对应的位置 - 失配符号在模式串中的位置
            int shift1 = j - badChar[haystack.charAt(i + j)];
            int shift2 = this.shiftByGoodSuffix();
            i += Math.max(shift1, shift2);
        }
        return -1;
    }

    private int shiftByGoodSuffix() {
        return 0;
    }
}

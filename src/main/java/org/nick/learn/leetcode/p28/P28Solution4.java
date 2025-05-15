package org.nick.learn.leetcode.p28;

import java.util.Arrays;

public class P28Solution4 {

    /**
     * BM 算法
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
            int shift = j - badChar[haystack.charAt(i + j)];

            shift = Math.max(1, shift);
            i += shift;
        }
        return -1;
    }


}

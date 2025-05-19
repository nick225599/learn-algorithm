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
            int shift2 = this.shiftByGoodSuffix(needle);
            i += Math.max(shift1, shift2);
        }
        return -1;
    }

    // suffix 数组。suffix 数组的下标 k，表示后缀子串的长度，下标对应的数组值存储的是，在模式串中跟好后缀{u}相匹配的子串{u*}的起始下标值。
    int[] suffix;

    private int shiftByGoodSuffix(String pattern) {
        if (null == suffix) {
            suffix = this.buildSuffix(pattern);
        }
        return 0;
    }

    private int[] buildSuffix(String pattern) {
        suffix = new int[pattern.length()];
        Arrays.fill(suffix, -1);
        int m = pattern.length();
        for (int i = 1; i <= suffix.length; i++) {
            String tmpSuffix = pattern.substring(m - i, m);
            for (int j = m - i; j - i >= 0; j--) {
                String left = pattern.substring(j - i, j);
                if (left.equals(tmpSuffix)) {
                    suffix[i] = j - i;
                    break;
                }
            }
        }
        return suffix;
    }

    public static void main(String[] args) {
        String pattern = "cabcab";
        // cabcab
        //      b suffix[1]=2
        //     ab suffix[2]=1
        //    cab suffix[3]=0
        //   bcab suffix[4]=-1
        //  abcab suffix[5]=-1
        //TODO nick 20250516 看下 suffix 数组怎么没算对
        int[] suffix = new P28Solution6().buildSuffix(pattern);
        System.out.println(Arrays.toString(suffix));
    }
}

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

        int[] goodSuffix = generateGoodSuffix(needle);

        int i = 0;
        while (i <= n - m) {
            int j = m - 1;
            while (j >= 0 && haystack.charAt(i + j) == needle.charAt(j)) {
                j--;
            }
            if (j < 0) {
                return i;
            }
            // 坏字符规则
            // 偏移量 = 失配符号在模式串中对应的位置 - 失配符号在模式串中的从右往左第一次出现的位置
            int shift1 = j - badChar[haystack.charAt(i + j)];

            // 好后缀规则
            // 偏移量 = 好后缀在模式串中从右往左第一次出现的位置
            //  or 好后缀最长右子串在模式串前子串中出现的位置
            //  or 直接跳过整个模式串的长度
            int shift2 = goodSuffix[j + 1];

            if(shift1 < shift2){
                System.out.println("好后缀让匹配加速了");
            }

            i += Math.max(shift1, shift2);
        }
        return -1;
    }

    private int[] generateGoodSuffix(String pattern) {
        int m = pattern.length();
        int[] suffix = this.getSuffixArray(pattern);
        return null;
    }

    private int[] getSuffixArray(String pattern) {
        int m = pattern.length();
        int[] suffix = new int[m];
        suffix[m - 1] = m;
        int f = 0, g = m - 1;

        for (int p = m - 2; p >= 0; p--) {
            if (p > f && suffix[p + m - 1 - g] < p - f) {
                suffix[p] = suffix[p + m - 1 - g];
            } else {
                if (p < f) f = p;
                g = p;
                while (g >= 0 && pattern.charAt(g) == pattern.charAt(g + m - 1 - f)) {
                    g--;
                }
                suffix[p] = f - g;
            }
        }

        return suffix;
    }

    public static void main(String[] args) {
        String pattern = "banana";
        // b a n a n a
        // 0 1 2 1 2 1
        int[] suffix = new P28Solution4().getSuffixArray(pattern);
        System.out.println(Arrays.toString(suffix));
    }


}

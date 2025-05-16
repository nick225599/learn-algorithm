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

        // Preprocessing for bad character rule and good suffix rule
        int[] badChar = generateBadCharTable(needle);
        int[] goodSuffix = generateGoodSuffixTable(needle);

        int i = 0; // Index in haystack
        while (i <= n - m) {
            // Compare from right to left
            int j = m - 1;
            while (j >= 0 && haystack.charAt(i + j) == needle.charAt(j)) {
                j--;
            }
            if (j < 0) {
                return i; // Match found
            }

            // Calculate shift distance based on bad character rule and good suffix rule
            int shiftByBadChar = j - badChar[haystack.charAt(i + j)];
            int shiftByGoodSuffix = goodSuffix[j];
            if (shiftByGoodSuffix > shiftByBadChar) {
                System.out.println("引入好后缀规则后匹配速度更快了");
            }
            i += Math.max(shiftByBadChar, shiftByGoodSuffix);
        }
        return -1; // No match found
    }

    private int[] generateBadCharTable(String pattern) {
        int[] table = new int[256]; // Assuming ASCII characters
        Arrays.fill(table, -1);
        for (int i = 0; i < pattern.length(); i++) {
            table[pattern.charAt(i)] = i;
        }
        return table;
    }

    private int[] generateGoodSuffixTable(String pattern) {
        int m = pattern.length();
        int[] goodSuffix = new int[m];
        int[] borderPosition = new int[m + 1];
        int i = m, j = m + 1;
        borderPosition[i] = j;

        while (i > 0) {
            while (j < m && pattern.charAt(i - 1) != pattern.charAt(j - 1)) {
                if (goodSuffix[j] == 0) goodSuffix[j] = j - i;
                j = borderPosition[j];
            }
            --i;
            --j;
            borderPosition[i] = j;
        }

        // Last step: fill remaining positions
        j = borderPosition[0];
        for (i = 0; i < m; i++) {
            if (goodSuffix[i] == 0) goodSuffix[i] = j;
            if (i == j) j = borderPosition[j];
        }

        return goodSuffix;
    }


}

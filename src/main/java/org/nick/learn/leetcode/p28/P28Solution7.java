package org.nick.learn.leetcode.p28;

import java.util.Arrays;

public class P28Solution7 {

    /**
     * BM 算法 -  AI 生成的版本，错的，死活改不对，算球
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) return 0;
        if (haystack == null || haystack.length() < needle.length()) return -1;

        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        int n = text.length;
        int m = pattern.length;

        // 构建坏字符表
        int[] badChar = createBadCharTable(pattern);

        // 构建好后缀表
        int[] goodSuffix = createGoodSuffixTable(pattern);

        // 主循环：从左到右滑动模式串
        for (int s = 0; s <= n - m;) {
            int j = m - 1;

            // 从右到左比较字符
            while (j >= 0 && pattern[j] == text[s + j]) {
                j--;
            }

            if (j < 0) {
                // 找到匹配，返回起始位置
                return s;
            } else {
                // 计算坏字符规则和好后缀规则的移动距离
                int badCharShift = j - badChar[text[s + j] & 0xFF];
                int goodSuffixShift = goodSuffix[j + 1];

                // 取较大的移动距离
                s += Math.max(badCharShift, goodSuffixShift);
            }
        }

        return -1; // 未找到匹配
    }

    // 构建坏字符表
    private int[] createBadCharTable(char[] pattern) {
        int[] badChar = new int[256];
        Arrays.fill(badChar, -1);

        for (int i = 0; i < pattern.length; i++) {
            badChar[pattern[i] & 0xFF] = i;
        }

        return badChar;
    }

    // 构建好后缀表
    private int[] createGoodSuffixTable(char[] pattern) {
        int m = pattern.length;
        int[] goodSuffix = new int[m + 1];
        int[] suffix = computeSuffix(pattern);

        // 情况1：没有好后缀，移动整个模式串
        Arrays.fill(goodSuffix, m);

        // 情况2：好后缀的一部分是模式串的前缀
        int j = 0;
        for (int i = m - 1; i >= -1; i--) {
            if (i == -1 || suffix[i] == i + 1) {
                for (; j < m - 1 - i; j++) {
                    if (goodSuffix[j] == m) {
                        goodSuffix[j] = m - 1 - i;
                    }
                }
            }
        }

        // 情况3：模式串中有子串与好后缀匹配
        for (int i = 0; i < m - 1; i++) {
            goodSuffix[m - 1 - suffix[i]] = m - 1 - i;
        }

        return goodSuffix;
    }

    // 计算后缀数组：suffix[i]表示以i位置结尾的子串，最长能匹配模式串后缀的长度
    private int[] computeSuffix(char[] pattern) {
        int m = pattern.length;
        int[] suffix = new int[m];
        suffix[m - 1] = m;

        int g = m - 1;
        int f = 0;

        for (int i = m - 2; i >= 0; i--) {
            if (i > g && suffix[i + m - 1 - f] < i - g) {
                suffix[i] = suffix[i + m - 1 - f];
            } else {
                if (i < g) {
                    g = i;
                }
                f = i;
                while (g >= 0 && pattern[g] == pattern[g + m - 1 - f]) {
                    g--;
                }
                suffix[i] = f - g;
            }
        }

        return suffix;
    }

    public static void main(String[] args) {
        P28Solution7 solution = new P28Solution7();
        String haystack = "ababbbbaaabbbaaa";
        String needle = "bbbb";
        System.out.println("匹配位置: " + solution.strStr(haystack, needle)); // 应该输出3
    }
}
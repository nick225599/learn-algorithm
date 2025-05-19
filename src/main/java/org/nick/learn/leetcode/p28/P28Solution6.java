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

        this.buildSuffix(needle);

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
            shift1 = Math.max(1, shift1);

            if (j < m - 1) {
                int shift2 = this.shiftByGoodSuffix(j, m);
                if (shift2 > shift1) {
                    System.out.println("好后缀规则进行了加速");
                }
                shift1 = Math.max(shift1, shift2);
            }
            i += shift1;
        }
        return -1;
    }


    private int shiftByGoodSuffix(int j, int m) {
        // 下标第 j 个字符不匹配
        // 那么匹配长度就是
        int l = m - 1 - j;
        int shift = suffix[l]; // baaa
        if (shift == -1) {
            for (int i = 1; i <= l; i++) {
                if (prefix[i]) {
                    shift = i;
                }
            }
        } else {
            shift = j + 1 - shift;
        }

        return shift;
    }

    private void buildSuffix(String pattern) {
        suffix = new int[pattern.length()];
        Arrays.fill(suffix, -1);
        prefix = new boolean[pattern.length()];
        int m = pattern.length();
        for (int i = 1; i <= suffix.length; i++) {
            for (int j = m - i; j - i >= 0; j--) {
                int k = 0;
                while (k < i && pattern.charAt(m - i + k) == pattern.charAt(j - i + k)) {
                    k++;
                }
                if (k == i) {
                    suffix[i] = j - i;
                    prefix[i] = j - i == 0;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        P28Solution6 solution = new P28Solution6();
        // abbba
        //       suffix[0] = -1
        //     a suffix[0] = 0
        //    ba suffix[1] = -1
        //   bba suffix[2] = -1
        //  bbba suffix[3] = -1
        solution.buildSuffix("abbba");
        System.out.println(Arrays.toString(solution.suffix));
        System.out.println(Arrays.toString(solution.prefix));

    }

    // suffix 数组。suffix 数组的下标 k，表示后缀子串的长度，下标对应的数组值存储的是，在模式串中跟好后缀{u}相匹配的子串{u*}的起始下标值。
    private int[] suffix;


    // boolean 类型的 prefix 数组，来记录模式串的后缀子串是否能匹配模式串的前缀子串。
    private boolean[] prefix;

}

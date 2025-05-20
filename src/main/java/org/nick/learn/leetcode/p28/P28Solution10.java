package org.nick.learn.leetcode.p28;

import java.util.Arrays;

public class P28Solution10 {

    /**
     * 照着王争老师的教程一步步来
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(n < m) return -1;

        int[] next = this.buildNextArr(needle);
        int j = 0;
        for(int i = 0; i < n;){
            // ababcaababcaabc
            // ababcaabc
            // ababcaab
            // abxxxxab
            //       abxxxxab
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1] + 1;
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                return i - m + 1;
            }
        }
        return -1;
    }

    // 数组的下标是每个前缀结尾字符下标
    // 数组的值是这个前缀的最长可以匹配前缀子串的结尾字符下标。
    // ababacd
    // a         next[0] = -1
    // ab        next[1] = -1
    // aba       next[2] = 0
    // abab      next[3] = 1
    // ababa     next[4] = 2
    // ababac    next[5] = -1
    private int[] buildNextArr(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && pattern.charAt(k + 1) != pattern.charAt(i)) {
                k = next[k];
            }
            if (pattern.charAt(k + 1) == pattern.charAt(i)) {
                ++k;
            }
            next[i] = k;
        }
        System.out.println("needle: " + pattern);
        System.out.println("int[] pi: " );
        System.out.println(Arrays.toString(next));
        System.out.println();
        return next;
    }



}
package org.nick.learn.leetcode.p28;

public class P28Solution11 {

    /**
     * KMP
     *
     * 卧槽 居然一遍就写对了
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (n < m) return -1;

        int[] next = this.buildNextArr(needle);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;

    }


    private int[] buildNextArr(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < m; i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = next[j - 1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
                next[i] = j;
            }
        }
        return next;
    }


}
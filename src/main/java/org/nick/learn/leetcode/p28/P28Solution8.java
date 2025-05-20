package org.nick.learn.leetcode.p28;

import java.util.Arrays;

public class P28Solution8 {

    /**
     * 力扣官方题解 KMP
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (n < m) {
            return -1;
        }
        int[] pi = this.buildArr(needle);
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
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

    private int[] buildArr(String needle) {
        int m = needle.length();
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        System.out.println("needle: " + needle);
        System.out.println("int[] pi: " );
        System.out.println(Arrays.toString(pi));
        System.out.println();
        return pi;
    }

    public static void main(String[] args) {
        int[] nullArr = new P28Solution8().buildArr("ababacd");
    }
}
package org.nick.learn.leetcode.p28;

import org.nick.learn.common.util.StringUtils;

import java.util.Arrays;

public class P28Solution10 {

    /**
     * 照着王争老师的教程一步步来
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (n < m) return -1;

        int[] next = this.buildNextArr(needle);
        int j = 0;
        for (int i = 0; i < n; i++) {
            // ababcaababcaabc
            // ababcaabc
            // ababcaab
            // abxxxxab
            //       abxxxxab
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1] + 1;
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m - 1;
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
        for (int i = 1; i < m; i++) { // i
            if (pattern.charAt(i) == pattern.charAt(i - m)) ;
        }
        return null;


//        int m = pattern.length();
//        int[] next = new int[m];
//        next[0] = -1;
//        int k = -1;
//        for (int i = 1; i < m; ++i) {
//            while (k != -1 && pattern.charAt(k + 1) != pattern.charAt(i)) {
//                k = next[k];
//            }
//            if (pattern.charAt(k + 1) == pattern.charAt(i)) {
//                ++k;
//            }
//            next[i] = k;
//        }
//        System.out.println("needle: " + pattern);
//        System.out.println("int[] pi: ");
//        System.out.println(Arrays.toString(next));
//        System.out.println();
//        return next;

    }


    int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n];

        // 初始化
        int prefix = 0; // 前缀末尾位置（i 之前、包括 i，之前的子串的最长相等前后缀的长度 ）
        int suffix = 1; // 后缀末尾位置
        next[0] = 0;
        for (; suffix < n; suffix++) {
            // 处理前后缀不同的情况
            while (prefix > 0 && s.charAt(suffix) != s.charAt(prefix)) {
                prefix = next[prefix - 1]; // 根据前一位前缀的 next 数组元素值进行回退
            }

            // 处理前后缀相同的情况
            if(s.charAt(suffix) == s.charAt(prefix)){
//                next[suffix] = next[suffix - 1] + 1;
                prefix++;
                next[suffix] = prefix;
            }



        }


        // 更新 next 的元素
        if(Arrays.toString(next).contains("2")){
            System.out.println("s: " + s);
            System.out.println("next: " + Arrays.toString(next));
        }

        return next;
    }

    public static void main(String[] args) {
        P28Solution10 solution = new P28Solution10();
//        for(int i = 0; i < 1000; i ++){
//        String str = StringUtils.generateRandomStr(8);
//        solution.getNext(str);
//        }


//        s: ufaufduo
//        next: [0, 0, 0, 1, 2, 0, 1, 0]
        solution.getNext("ufaufduo");

    }


}
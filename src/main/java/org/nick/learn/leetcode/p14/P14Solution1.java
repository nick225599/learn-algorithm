package org.nick.learn.leetcode.p14;

import java.util.Arrays;

public class P14Solution1 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String startStr = strs[0];
        String endStr = strs[strs.length - 1];
        int n = Math.min(startStr.length(), endStr.length());
        int i;
        for (i = 0; i < n; i++) {
            if (startStr.length() < i + 1
                    || endStr.length() < i + 1
                    || startStr.charAt(i) != endStr.charAt(i)) {
                break;
            }
        }
        return strs[0].substring(0, i);
    }
}

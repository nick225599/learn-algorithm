package org.nick.learn.leetcode.p3;

public class P3Solution4 {
    // 网友们的清爽版解法
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        boolean[] booleans = new boolean[128];
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (booleans[c]) {
                booleans[s.charAt(j)] = false;
                j++;
            }
            booleans[c] = true;
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}

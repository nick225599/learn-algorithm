package org.nick.learn.leetcode.p58;

public class P58Solution1 {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int startIndex = -1;
        int endIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (endIndex == -1) {
                if (' ' != c) {
                    endIndex = i + 1;
                }
            } else {
                if (' ' == c) {
                    startIndex = i;
                    break;
                }
            }
        }
        return endIndex - startIndex - 1;
    }
}

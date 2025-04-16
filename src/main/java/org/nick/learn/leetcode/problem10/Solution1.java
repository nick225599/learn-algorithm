package org.nick.learn.leetcode.problem10;

public class Solution1 {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        while (true) {
            if (i >= s.length() && j >= p.length()) {
                return true;
            } else {
                if (i >= p.length()) {
                    return false;
                }
                if (j >= p.length()) {
                    return false;
                }
            }

            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if (p.charAt(j) == '*') {
                if (s.charAt(i) == p.charAt(j - 1)) {
                    i++;
                    continue;
                }
                if (s.charAt(i) == p.charAt(j + 1)) {
                    j++;
                    continue;
                }
            }
            if(p.charAt(j) == '.'){
                i++;
                j++;
                continue;
            }
        }
    }
}

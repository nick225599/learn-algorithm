package org.nick.learn.leetcode.problem10;

public class Solution2 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (match(s, p, i, j - 1)) {
                        f[i][j] = f[i - 1][j] || f[i][j - 2];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        return '.' == p.charAt(j - 1) || s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        String s = "aaa";
        String p = ".*";
        System.out.println(new Solution2().isMatch(s, p));
    }
}

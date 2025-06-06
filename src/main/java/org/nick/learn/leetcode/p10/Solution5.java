package org.nick.learn.leetcode.p10;

public class Solution5 {

    // 尝试从 i=0 j=0 开始迭代
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = true;
                    } else if (j >= 2 && p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 2];
                    }
                    continue;
                } else if (j == 0) {
                    continue;
                }


                if (p.charAt(j - 1) != '*') {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false; // 并没有提前终止
                    }
                } else {
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] = (dp[i - 1][j] || dp[i][j - 2]);
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        return '.' == p.charAt(j - 1) || s.charAt(i - 1) == p.charAt(j - 1);
    }


}

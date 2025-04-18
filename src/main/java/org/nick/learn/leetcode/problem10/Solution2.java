package org.nick.learn.leetcode.problem10;

public class Solution2 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 1;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 0; // 并没有提前终止
                    }
                } else {
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] = (dp[i - 1][j] == 1 || dp[i][j - 2] == 1) ? 1 : 0;
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n] == 1;
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

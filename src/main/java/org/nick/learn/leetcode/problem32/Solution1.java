package org.nick.learn.leetcode.problem32;

public class Solution1 {

    /**
     * 解法错的，因为没想到 (()()) 也认为是有效的，有效长度 6 ......
     */
    public int longestValidParentheses(String s) {
        int result = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (')' == c) {
                if (i - 1 >= 0 && '(' == s.charAt(i - 1)) {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] += dp[i - 2]; // 动态规划
                    }
                    result = Math.max(result, dp[i]);
                }
                if (i - 1 >= 0 && ')' == s.charAt(i - 1)) {
                    if (dp[i - 1] > 0) {
                        boolean b1 = i - dp[i - 1] - 1 >= 0; // 上一个有效字符串的前一位有值
                        if(b1){
                            boolean b2 = '(' == s.charAt(i - dp[i - 1] - 1); // 上一位有效字符串的前一位值是 (
                            if (b2) {
                                dp[i] = 2 + dp[i - 1];
                                if (i - dp[i - 1] - 2 >= 0) {
                                    dp[i] += dp[i - dp[i - 1] - 2];
                                }
                                result = Math.max(result, dp[i]);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
package org.nick.learn.leetcode.problem32;

public class Solution1 {

    /**
     * 解法错的，因为没想到 (()()) 也认为是有效的，有效长度 6 ......
     */
    public int longestValidParentheses(String s) {
        int longestCount = 0;
        int tmpSum = 0;
        int tmpCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                tmpSum++;

                if (tmpSum > 1) {
                    tmpSum = 1;


                } else {
                    tmpCount++;
                    if (tmpCount >= 2 && longestCount < tmpCount) {
                        longestCount = tmpCount;
                    }
                }
            }
            if (')' == c) {
                tmpSum--;

                if (tmpSum < 0) {
                    tmpSum = 0;

                } else {
                    tmpCount++;

                    if (tmpCount >= 2 && longestCount < tmpCount) {
                        longestCount = tmpCount;
                    }
                }
            }
        }
        return longestCount;
    }
}

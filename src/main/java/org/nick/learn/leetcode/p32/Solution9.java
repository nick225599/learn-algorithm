package org.nick.learn.leetcode.p32;

public class Solution9 implements Solution {

    // 双端遍历法
    public int longestValidParentheses(String s) {
        int leftParenCount = 0;
        int rightParenCount = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                leftParenCount++;
            }
            if (')' == c) {
                rightParenCount++;
                if (leftParenCount == rightParenCount) {
                    result = Math.max(result, leftParenCount + rightParenCount);
                } else if (leftParenCount < rightParenCount) {
                    leftParenCount = rightParenCount = 0;
                }
            }
        }
        leftParenCount = rightParenCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (')' == c) {
                rightParenCount++;
            }
            if ('(' == c) {
                leftParenCount++;
                if (leftParenCount == rightParenCount) {
                    result = Math.max(result, leftParenCount + rightParenCount);
                } else if (leftParenCount > rightParenCount) {
                    leftParenCount = rightParenCount = 0;
                }
            }
        }
        return result;
    }

}
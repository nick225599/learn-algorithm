package org.nick.learn.leetcode.problem32;

import java.util.Deque;
import java.util.LinkedList;

public class Solution3 implements Solution {



    /**
     * 暴力解法
     */
    @Override
    public int longestValidParentheses(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if ((j - i + 1) % 2 != 0) {
                    continue;
                }
                int validLength = this.detectValidLength(s, i, j);
                result = Math.max(result, validLength);
            }
        }
        return result;
    }

    /**
     * 使用栈判断字符串是否有效
     */
    private int detectValidLength(String targetStr, int startIndex, int endIndex) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = startIndex; i <= endIndex; i++) {
            char c = targetStr.charAt(i);
            if ('(' == c) {
                deque.offerFirst(c);
            }
            if (')' == c) {
                Character preChar = deque.pollFirst();
                if (null == preChar) {
                    return -1;
                }
            }
        }
        return deque.isEmpty() ? (endIndex - startIndex + 1) : -1;
    }
}
package org.nick.learn.leetcode.p32;

import java.util.Deque;
import java.util.LinkedList;

public class Solution8 implements Solution {

    // 栈写法
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                stack.push(i);
            }
            if (')' == c) {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

}
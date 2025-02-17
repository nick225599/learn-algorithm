package org.nick.learn.leetcode.problem32;

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

    // 写对了，思想就是在堆栈里存没能被匹配的字符的下标，
    // 一旦有字符被匹配，就用被匹配的字符下标减去最近一个未能被匹配的字符的下标，就能算出当前匹配的字符对应的有效长度了
    //todo nick_sun 20250215 再把代码简洁一下

}
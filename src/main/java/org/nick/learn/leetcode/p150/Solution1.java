package org.nick.learn.leetcode.p150;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {

    // 栈
    // O(n) 的时间复杂度，居然耗时垫底。。。
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>(tokens.length);
        for (String token : tokens) {
            if (isOperator(token)) {
                int operandR = stack.pop();
                int operandL = stack.pop();
                switch (token) {
                    case "+" -> stack.push(operandL + operandR);
                    case "-" -> stack.push(operandL - operandR);
                    case "*" -> stack.push(operandL * operandR);
                    case "/" -> stack.push(operandL / operandR);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {

        // 别用正则判断，耗时一下子就减少了
//        return token.matches("[+\\-*/]");

        return "+".equals(token)
                || "-".equals(token)
                || "*".equals(token)
                || "/".equals(token);
    }
}

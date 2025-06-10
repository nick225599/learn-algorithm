package org.nick.learn.leetcode.p71;

import java.util.ArrayDeque;
import java.util.Deque;

public class P71Solution1 {


    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] strs = path.split("/");
        for (String str : strs) {
            if (str.isBlank()) {
                continue;
            }
            while ("/".equals(stack.peek())) {
                stack.pop();
            }
            stack.push("/");
            switch (str) {
                case "/":
                    while ("/".equals(stack.peek())) {
                        stack.pop();
                    }
                    stack.push("/");
                    break;
                case "..":
                    if (stack.size() >= 3) {
                        stack.pop();
                        stack.pop();
                        stack.pop();
                    }
                    break;
                case ".":
                    stack.pop();
                    break;
                default:
                    stack.push(str);
            }
        }
        if (stack.size() >= 3 && "/".equals(stack.peek())) {
            stack.pop();
        }
        stack = stack.reversed();
        if (stack.isEmpty()) {
            stack.push("/");
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}

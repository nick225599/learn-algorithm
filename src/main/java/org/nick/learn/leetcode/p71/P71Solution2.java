package org.nick.learn.leetcode.p71;

import java.util.ArrayDeque;
import java.util.Deque;

public class P71Solution2 {

    public String simplifyPath(String path) {
        char[] chars = path.toCharArray();
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (c != '/') {
                sb.append(c);
            } else {
                this.putIntoStack(stack, sb);
            }
        }
        this.putIntoStack(stack, sb);
        if (stack.isEmpty()) {
            return "/";
        }
        stack = stack.reversed();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private void putIntoStack(Deque<String> stack, StringBuilder sb) {
        String word = sb.toString();
        switch (word) {
            case "":
                break;

            case ".":
                break;

            case "..":
                if (stack.size() >= 2) {
                    stack.pop();
                    stack.pop();
                }
                break;

            default:
                stack.push("/");
                stack.push(word);
                break;
        }
        if (!sb.isEmpty()) {
            sb.setLength(0);
        }
    }
}

package org.nick.learn.leetcode.p71;

import java.util.ArrayDeque;
import java.util.Deque;

public class P71Solution3 {

    // 栈只存放目录名，进一步进化逻辑
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String element : arr) {
            if ("".equals(element) || ".".equals(element)) {
                continue;
            }
            if ("..".equals(element)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(element);
            }
        }

        if(stack.isEmpty()){
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollLast());
        }
        return sb.toString();
    }

}
